package cleancode.studycafe.tobe.model.pass;

import cleancode.studycafe.tobe.io.provider.SeatPassFileReader;
import cleancode.studycafe.tobe.provider.SeatPassProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeSeatPassesTest {

  @DisplayName("시간 단위, 주 단위, 고정권 이용권 각 종류에 대한 모든 이용권을 반환한다.")
  @Test
  void findPassCandidateByPassType() {
    //시간 단위 given
    SeatPassProvider seatPassProvider = new SeatPassFileReader();
    StudyCafeSeatPasses seatPasses = seatPassProvider.getSeatPasses();

    StudyCafePassType hourly = StudyCafePassType.HOURLY;

    // when
    List<StudyCafeSeatPass> hourlyPasses = seatPasses.findPassBy(hourly);

    // then
    assertThat(hourlyPasses).hasSize(6);
    assertThat(hourlyPasses.get(0).getPassType()).isEqualTo(hourly);

    // 주 단위 given
    StudyCafePassType weekly = StudyCafePassType.WEEKLY;

    // when
    List<StudyCafeSeatPass> weeklyPasses = seatPasses.findPassBy(weekly);

    // then
    assertThat(weeklyPasses).hasSize(5);
    assertThat(weeklyPasses.get(0).getPassType()).isEqualTo(weekly);

    // 고정권 given
    StudyCafePassType fixed = StudyCafePassType.FIXED;

    // when
    List<StudyCafeSeatPass> fixedPasses = seatPasses.findPassBy(fixed);

    // then
    assertThat(fixedPasses).hasSize(2);
    assertThat(fixedPasses.get(0).getPassType()).isEqualTo(fixed);
  }
}
