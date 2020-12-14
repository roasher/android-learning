package ru.pyurkin.pddtest.screens.tests

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_test.*
import ru.pyurkin.pddtest.R
import ru.pyurkin.pddtest.helpers.injectViewModel
import ru.pyurkin.pddtest.screens.PddTestApplication
import javax.inject.Inject

class TestsFragment : Fragment(R.layout.fragment_test) {

    companion object {
        val AUTH_TOKEN = "authToken"
    }

    @Inject
    lateinit var viewModeFactory: ViewModelProvider.Factory
    lateinit var testsViewModel: TestsViewModel

    private val testsAdapter: TestsAdapter = TestsAdapter(object : OnCheckBoxClick {
        override fun doOnCheckBoxClick(model: TestsAdapter.TestModel, checkBox: AppCompatCheckBox) {
            model.isChecked = checkBox.isChecked
        }
    })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity?.application as? PddTestApplication)?.appComponent?.inject(this);
        super.onViewCreated(view, savedInstanceState)

        testsViewModel = injectViewModel(factory = viewModeFactory)

        val authToken = this.arguments?.getString(AUTH_TOKEN)

        test_list.adapter = testsAdapter;
        test_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        configureViewModel()
        testsViewModel.generateData()
    }

    private fun configureViewModel() {
        testsViewModel.items.observe(viewLifecycleOwner, Observer {data ->
            testsAdapter.setModel(data)
        })
        testsViewModel.errors.observe(viewLifecycleOwner, Observer {error ->
            if (error.isNotBlank()) {
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
            }
        })
    }

}