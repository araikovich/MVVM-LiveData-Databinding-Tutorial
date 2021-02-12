package araikovich.studio.mvvmtutorial.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class TestFragment: Fragment() {

    val viewModel: TestViewModel by viewModels()
}