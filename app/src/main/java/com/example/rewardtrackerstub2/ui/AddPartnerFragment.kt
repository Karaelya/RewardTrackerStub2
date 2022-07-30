package com.example.rewardtrackerstub2.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.rewardtrackerstub2.RewardApplication
import com.example.rewardtrackerstub2.databinding.FragmentAddPartnerBinding
import com.example.rewardtrackerstub2.ui.viewmodel.RewardViewModel
import com.example.rewardtrackerstub2.ui.viewmodel.RewardViewModelFactory
import kotlinx.coroutines.*

class AddPartnerFragment : Fragment() {
    private var _binding: FragmentAddPartnerBinding? = null
    private val binding get() = _binding!!

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    private var partnerID: Long = 0L

    private val viewModel: RewardViewModel by activityViewModels {
        RewardViewModelFactory(
            (activity?.application as RewardApplication).database.RewardDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "OnCreate View")
        _binding = FragmentAddPartnerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "Pre Binding")
        binding.saveBtn.setOnClickListener {
            uiScope.launch(Dispatchers.IO) {
                addPartner()
            }

            val action = AddPartnerFragmentDirections
                .actionAddPartnerFragmentToPartnerDetailFragment(partnerID)
            findNavController().navigate(action)


        }
    }

    private fun addPartner() {
        partnerID = viewModel.addNewPartner(
            binding.guyFirstInput.text.toString(),
            binding.guyLastInput.text.toString(),
            binding.girlFirstInput.text.toString(),
            binding.girlLastInput.text.toString()
        )
    }
}