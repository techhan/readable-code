package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gamelevel.Beginner;
import cleancode.minesweeper.tobe.gamelevel.GameLevel;
import cleancode.minesweeper.tobe.gamelevel.Middle;
import cleancode.minesweeper.tobe.gamelevel.VeryBeginner;
import cleancode.minesweeper.tobe.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.io.ConsoleOutputHandler;
import cleancode.minesweeper.tobe.io.InputHandler;
import cleancode.minesweeper.tobe.io.OutputHandler;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameApplication {

    public static void main(String[] args) {
        GameLevel gameLevel = new Beginner();

        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        Minesweeper minesweeper = new Minesweeper(gameLevel, inputHandler, outputHandler);
        minesweeper.initialize();
        minesweeper.run();
    }

    /**
     * DIP(Dependency Inversion Principle)
     * 고수준 모듈과 저수준 모듈이 직접적으로 의존하는 것이 아니라, 추상화에 의존해야한다.
     *
     * spring IoC, DI, PSA, AOP
     * DI(Dependency Injection) - 의존성 주입
     * 필요한 의존성을 직접 생성하는게 아니라 외부에서 주입받겠다.
     * DI하면 3이 떠올라야함.
     * A 객체, B 객체.. A가 B를 필요로함. A에서 생성자를 통해 B를 주입받고자 함.
     * A, B는 서로를 직접적으로 의존성을 추가하지 못하고 제 3자를 통해 주입 받을 수 있음 -> 주입 해주는게 스프링 컨텍스트 Ioc container
     * 객체의 결정과 주입은 런타임 시점에 일어남.
     *
     * IoC(Inversion of Control) - 제어의 역전
     * 프로그램의 흐름을 개발자가 아닌 프레임워크에서 관리하게 함
     * 제어의 순방향 : 프로그램이라는 것은 개발자가 만드는 거니 개발자가 흐름을 주도
     * 제어의 역방향 : 어떤 미리 만들어져있는 프레임워크에 내 코드가 들어가서 동작하게 하는 것.
     * 객체의 생성이나 소멸을 프레임워크에서 알아서 해줌
     * @Component @Service 이런거 쓰면 스프링 프레임워크에서 알아서 생성해줌..
     *
     */
}
