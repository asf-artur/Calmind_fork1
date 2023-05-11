package com.example.calmind

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.calmind.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLogin.setOnClickListener {
            /**
             * TODO:
             * здесь мы устанавливаем опции, чтобы форма авторизации не открывалась по нажатию на кнопку назад
             *
             */
            val navOptions = navOptions {
                this.popUpTo(R.id.nav_login){
                    this.inclusive = true
                }
            }

            /**
             * TODO:
             * здесь была проблема, т.к. были перепутаны ID по навигации, т.к. было несколько фрагментов с одинаковыми названиями
             * раньше навигация бралась из файла @see [nav_graph.xml], а должна была из @see [mobile_navigation.xml]
             */
            findNavController().navigate(R.id.action_nav_login_to_nav_home, null, navOptions)
        }
    }
}