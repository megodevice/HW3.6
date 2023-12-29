package com.geeks.hw36

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geeks.hw36.databinding.FragmentMainBinding

class MainFragment : Fragment(), OnItemClick {
    private lateinit var binding: FragmentMainBinding
    private val continentList = ArrayList<Continent>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (continentList.isEmpty()) loadData(continentList)
        binding.rvContinents.adapter = ContinentAdapter(continentList, this)
    }

    override fun onItemClick(position: Int) {
        val bundle = Bundle()
        bundle.putSerializable(Keys.COUNTRY.name, continentList[position])
        val fragment = ContinentCountriesFragment()
        fragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment).addToBackStack(null).commit()
    }

    private fun loadData(list: ArrayList<Continent>) {
        list += Continent(
            "Евразия",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Eurasia_%28orthographic_projection%29.svg/200px-Eurasia_%28orthographic_projection%29.svg.png",
            arrayListOf(
                "Россия",
                "Китай",
                "Индия",
                "Казахстан",
                "Монголия",
                "Германия",
                "Пакистан",
                "Малайзия"
            )
        )
        list += Continent(
            "Северная Америка",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Location_North_America.svg/200px-Location_North_America.svg.png",
            arrayListOf(
                "Канада",
                "США",
                "Мексика",
                "Никарагуа",
                "Гондурас",
                "Куба",
                "Гватемала",
                "Панама"
            )
        )
        list += Continent(
            "Южная Америка",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/South_America_%28orthographic_projection%29.svg/200px-South_America_%28orthographic_projection%29.svg.png",
            arrayListOf(
                "Бразилия",
                "Аргентина",
                "Перу",
                "Колумбия",
                "Боливия",
                "Венесуэлла",
                "Чили",
                "Парагвай"
            )
        )
        list += Continent(
            "Африка",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Africa_%28orthographic_projection%29.svg/200px-Africa_%28orthographic_projection%29.svg.png",
            arrayListOf("Алжир", "Конго", "Судан", "Ливия", "Чад", "Нигер", "Ангола", "Мали")
        )
        list += Continent(
            "Австралия и океания",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Australia_%28orthographic_projection%29.svg/200px-Australia_%28orthographic_projection%29.svg.png",
            arrayListOf(
                "Австралия",
                "Папуа - Новая Гвинея",
                "Новая Зеландия",
                "Соломоновы Острова",
                "Фиджи",
                "Вануату",
                "Самоа",
                "Тонга"
            )
        )
    }
}