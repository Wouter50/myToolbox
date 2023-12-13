package com.example.mytoolbox.ui.games

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mytoolbox.R
import com.example.mytoolbox.databinding.FragmentGamesBinding
import com.example.mytoolbox.ui.games.TicTacToeActivity

class GamesFragment : Fragment() {

    private var _binding: FragmentGamesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val gamesViewModel =
            ViewModelProvider(this).get(GamesViewModel::class.java)

        _binding = FragmentGamesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        gamesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val ticTacToe = root.findViewById(R.id.ticTacToe) as TextView
        ticTacToe.setOnClickListener{
            val intent = Intent (activity, TicTacToeActivity::class.java)
            activity?.startActivity(intent)
        }



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}