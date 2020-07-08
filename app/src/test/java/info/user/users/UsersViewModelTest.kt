package info.user.users

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import info.user.api.ApiService
import info.user.users.UsersViewModel.Companion.USERS_MODEL_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class UsersViewModelTest {
    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testScope.cleanupTestCoroutines()
    }

    @Test
    fun getUsers() = testScope.runBlockingTest {
        val mockApiService = mock<ApiService> {
            onBlocking { getUsers() } doReturn listOf()
            //TODO create list of users as predefined response to test
        }
        val mockSavedStateHandle = mock<SavedStateHandle> {
            onBlocking { getLiveData<UserModelList>(USERS_MODEL_KEY) } doReturn MutableLiveData<UserModelList>()
        }
        val viewModel by lazy {
            UsersViewModel(
                mockApiService,
                mockSavedStateHandle
            )
        }
    }
}
