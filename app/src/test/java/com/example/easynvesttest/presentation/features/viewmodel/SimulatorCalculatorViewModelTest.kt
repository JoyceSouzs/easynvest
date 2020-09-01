package com.example.easynvesttest.presentation.features.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.easynvesttest.data.TestSimulatorCalculatorData.simulator_data
import com.example.easynvesttest.domain.request.ParametersRequest
import com.example.easynvesttest.presentation.model.SimulatorCalculatorData
import com.example.easynvesttest.providers.repository.SimulatorCalculatorRepository
import com.example.easynvesttest.util.SimulatorCalculatorResult
import org.junit.Assert.assertNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SimulatorCalculatorViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    val viewModel = SimulatorCalculatorViewModel(FakeSimulatorCalculatorRepository(
        SimulatorCalculatorResult.Success(simulator_data)))

    @Test
    fun `when view model calculatorInvestment get success then sets _simulatorCalculatorData`()
            = testDispatcher.runBlockingTest {

        //when
        viewModel.calculatorInvestment()

        //then
        assertEquals(simulator_data, viewModel.simulatorCalculatorData.value)
        assertEquals(false, viewModel.loadingLiveData.value)
        assertNotNull(viewModel.navigateToResultAction.value)

    }

    @Test
    fun `when view model setParameters sets parametersRequest`()
            = testDispatcher.runBlockingTest {
        //given
        val parameters = ParametersRequest(
            investedAmount = 32323.0,
            rate = 123.0,
            maturityDate = "2023-03-03"
        )

        //when
        viewModel.setParameters(parameters)

        //then
        assertEquals(parameters, viewModel.parameters)

    }

    internal class FakeSimulatorCalculatorRepository(
        private val result: SimulatorCalculatorResult<SimulatorCalculatorData>
    ) : SimulatorCalculatorRepository {

        override suspend fun getInvestmentValues(parametersRequest: ParametersRequest)
                : SimulatorCalculatorResult<SimulatorCalculatorData> {
            return result
        }
    }
}