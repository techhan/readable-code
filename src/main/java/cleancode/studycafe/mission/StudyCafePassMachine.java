package cleancode.studycafe.mission;

import cleancode.studycafe.mission.exception.AppException;
import cleancode.studycafe.mission.io.InputHandler;
import cleancode.studycafe.mission.io.OutputHandler;
import cleancode.studycafe.mission.io.StudyCafeFileHandler;
import cleancode.studycafe.mission.model.StudyCafeLockerPass;
import cleancode.studycafe.mission.model.StudyCafePass;
import cleancode.studycafe.mission.model.StudyCafePassType;

import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            outputHandler.askPassTypeSelection();
            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();

            List<StudyCafePass> studyCafePasses = getAllPassTypes();
            List<StudyCafePass> passCandidates = filterByPassType(studyCafePasses, studyCafePassType);

            outputHandler.showPassListForSelection(passCandidates);
            StudyCafePass selectedPass = inputHandler.getSelectPass(passCandidates);

            StudyCafeLockerPass lockerPass = selectLockerPass(selectedPass);

            if(hasLockerPass(lockerPass)) {
                outputHandler.showPassOrderSummary(selectedPass, lockerPass);
                return;
            }

            outputHandler.showPassOrderSummary(selectedPass, null);
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private boolean hasLockerPass(StudyCafeLockerPass lockerPass) {
        return lockerPass != null;
    }

    private StudyCafeLockerPass selectLockerPass(StudyCafePass selectedPass) {
        List<StudyCafeLockerPass> lockerPasses = studyCafeFileHandler.readLockerPasses();

        StudyCafeLockerPass lockerPassCandidate = lockerPasses.stream()
                .filter(option ->
                        option.getPassType() == selectedPass.getPassType()
                                && option.getDuration() == selectedPass.getDuration()
                )
                .findFirst()
                .orElse(null);

        if (hasLockerPass(lockerPassCandidate)) {
            outputHandler.askLockerPass(lockerPassCandidate);
            boolean isLockerSelected = inputHandler.getLockerSelection();

            if(isLockerSelected) {
                return lockerPassCandidate;
            }
        }

        return null;
    }

    private List<StudyCafePass> getAllPassTypes() {
        return studyCafeFileHandler.readStudyCafePasses();
    }

    private List<StudyCafePass> filterByPassType(List<StudyCafePass> studyCafePasses, StudyCafePassType studyCafePassType) {
        return studyCafePasses.stream()
                .filter(studyCafePass -> studyCafePass.getPassType() == studyCafePassType)
                .toList();
    }
}
