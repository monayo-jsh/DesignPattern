import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SubSystemFacadeTest {

    @Mock
    private SubSystemOne subSystemOne;

    @Mock
    private SubSystemTwo subSystemTwo;

    @Mock
    private SubSystemThree subSystemThree;

    @Mock
    private SubSystemFour subSystemFour;

    @InjectMocks
    private SubSystemFacade subSystemFacade;

    @Test
    @DisplayName("Facade Method A 동작 검증")
    void test1() {
        subSystemFacade.methodA();

        verify(subSystemOne, times(1)).method();
        verify(subSystemTwo, times(1)).method();
        verify(subSystemThree, times(1)).method();
        verify(subSystemFour, never()).method();
    }

    @Test
    @DisplayName("Facade Method B 동작 검증")
    void test2() {
        subSystemFacade.methodB();

        verify(subSystemOne, never()).method();
        verify(subSystemTwo, times(1)).method();
        verify(subSystemThree, never()).method();
        verify(subSystemFour, times(1)).method();
    }
}