import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.navigation.base.BaseFragment
import com.example.navigation.databinding.ActivityMainBinding
import com.example.navigation.databinding.AnotherFragmentBinding

class AnotherFragment : BaseFragment<AnotherFragmentBinding>() {

     private val args: AnotherFragmentArgs by navArgs()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): AnotherFragmentBinding = AnotherFragmentBinding.inflate(inflater, container, false)

    override fun AnotherFragmentBinding.onBindView(savedInstanceState: Bundle?) {
        textView.setOnClickListener {
            navController.popBackStack()
        }

        println("args.fragmentId = ${args.fragmentId}")
        println("args.fragmentId = ${args.description}")
    }
}