package com.example.rewardtrackerstub2.ui

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.rewardtrackerstub2.RewardApplication
import com.example.rewardtrackerstub2.databinding.FragmentPartnerDetailsBinding
import com.example.rewardtrackerstub2.model.PartnerDetails
import com.example.rewardtrackerstub2.ui.viewmodel.RewardViewModel
import com.example.rewardtrackerstub2.ui.viewmodel.RewardViewModelFactory

class PartnerDetailFragment : Fragment() {
    private val navigationArgs: PartnerDetailFragmentArgs by navArgs()

    private val viewModel: RewardViewModel by activityViewModels {
        RewardViewModelFactory(
            (activity?.application as RewardApplication).database.RewardDao()
        )
    }

    private lateinit var partnerDetails: PartnerDetails

    private var _binding: FragmentPartnerDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPartnerDetailsBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val partnerID = navigationArgs.id
        if (partnerID != 0L) {
            partnerDetails = viewModel.getPartner(partnerID)
            val partnerNames = (partnerDetails.guyFirst + " " + partnerDetails.guyLast + " & " +
                    partnerDetails.girlFirst + " " + partnerDetails.girlLast)
            binding.partnerName.text = partnerNames
            }
        binding.addPartner.setOnClickListener {
            val action = PartnerDetailFragmentDirections
                .actionPartnerDetailFragmentToAddPartnerFragment()
            findNavController().navigate(action)
        }
    }
}