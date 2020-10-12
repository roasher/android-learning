package ru.pyurkin.pddtest.screens.tests

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_test.*
import ru.pyurkin.pddtest.R

class TestsFragment : Fragment(R.layout.fragment_test) {

    companion object {
        val AUTH_TOKEN = "authToken"
    }

    private val testsAdapter: TestsAdapter = TestsAdapter(object : OnCheckBoxClick {
        override fun doOnClick(model: TestsAdapter.TestModel, checkBox: AppCompatCheckBox) {
            model.isChecked = checkBox.isChecked
        }
    })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val authToken = this.arguments?.getString(AUTH_TOKEN)

        test_list.adapter = testsAdapter;
        test_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val model = ArrayList<TestsAdapter.Model>()
        for (i in 0..20) {
            model.add(TestsAdapter.TestModel("simple name${i}", false, R.mipmap.ic_launcher))
        }
        model.set(4, TestsAdapter.BannerModel(R.mipmap.ic_launcher))
        model.set(7, TestsAdapter.BannerModel(R.mipmap.img_logo))
        testsAdapter.setModel(model)
    }
}