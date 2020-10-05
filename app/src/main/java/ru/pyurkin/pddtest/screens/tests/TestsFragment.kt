package ru.pyurkin.pddtest.screens.tests

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.test_cell.*
import kotlinx.android.synthetic.main.tests_fragment.*
import ru.pyurkin.pddtest.R
import java.util.stream.IntStream
import java.util.stream.StreamSupport

class TestsFragment : Fragment(R.layout.tests_fragment) {

    companion object {
        val AUTH_TOKEN = "authToken"
    }

    private val testsAdapter: TestsAdapter = TestsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val authToken = this.arguments?.getString(AUTH_TOKEN)

        test_list.adapter = testsAdapter;
        test_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val model = ArrayList<TestModel>()
        for (i in 0..20) {
            model.add(TestModel("simple name${i}", false, R.mipmap.ic_launcher))
        }
        testsAdapter.setModel(model)
    }
}