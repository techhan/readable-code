package cleancode.studycafe.tobe.io;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputHandlerTest {

    @DisplayName("사용자가 시간 단위(1) or 주 단위(2) or 고정 이용권(3) 중 하나를 선택한다.")
    @Test
    void userSelectedPassType() {
        //given
        InputHandler inputHandler = new InputHandler();

        // when
        StudyCafePassType passTypeSelectingUserAction1 = inputHandler.getPassTypeSelectingUserAction("1");

        // then
        assertThat(passTypeSelectingUserAction1).isEqualTo(StudyCafePassType.HOURLY);

        // when
        StudyCafePassType passTypeSelectingUserAction2 = inputHandler.getPassTypeSelectingUserAction("2");

        // then
        assertThat(passTypeSelectingUserAction2).isEqualTo(StudyCafePassType.WEEKLY);

        // when
        StudyCafePassType passTypeSelectingUserAction3 = inputHandler.getPassTypeSelectingUserAction("3");

        // then
        assertThat(passTypeSelectingUserAction3).isEqualTo(StudyCafePassType.FIXED);
    }

    @DisplayName("사용자가 제시 된 이용권(1~3) 외에 다른 번호를 선택한다.")
    @Test
    void userSelectedPassTypeInvalid() {
        // given
        InputHandler inputHandler = new InputHandler();

        // when

        // then
        assertThatThrownBy(() -> inputHandler.getPassTypeSelectingUserAction("4"))
                .isInstanceOf(AppException.class)
                .hasMessage("잘못된 입력입니다.");
    }
}
