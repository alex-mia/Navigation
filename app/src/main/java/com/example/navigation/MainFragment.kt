
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.navigation.MainFragmentViewModel
import com.example.navigation.base.BaseFragment
import com.example.navigation.data.UserRepositorylmpl
import com.example.navigation.data.converters.UserToUserNameConverter
import com.example.navigation.data.storage.SharedPrefUserStorage
import com.example.navigation.databinding.MainFragmentBinding
import com.example.navigation.domain.UserParamToUserConverter
import com.example.navigation.domain.base.GetUserNameUseCase
import com.example.navigation.domain.base.SaveUserNameUseCase
import com.example.navigation.domain.models.UserNameParam
import com.example.navigation.domain.repository.UserRepository


class MainFragment : BaseFragment<MainFragmentBinding>() {
    private  lateinit var viewModel: MainFragmentViewModel
    private val userStorage by lazy { SharedPrefUserStorage(requireActivity().applicationContext) }
    private val userRepository by lazy {
        UserRepositorylmpl(
            userStorage,
            UserParamToUserConverter(),
            UserToUserNameConverter()
        )
    }

    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = MainFragmentViewModel(getUserNameUseCase, saveUserNameUseCase)
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): MainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false)

    override fun MainFragmentBinding.onBindView(savedInstanceState: Bundle?) {
        receiveButton.setOnClickListener {
            viewModel.load()
        }
        saveButton.setOnClickListener {
            val userName = dataEdittext.text.toString()
            viewModel.save(userName)
        }

        viewModel.resultLiveData.observe(viewLifecycleOwner) { message ->
            dateTextview.text = message
        }
    }
}