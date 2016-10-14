/**
 * Created by Greymoon on 10/6/2016.
 */

public enum MenuOptionEnum implements IMakeGameMethod{
    EXIT{
        public Game makeGameWithView(IView view){
            return new Game();
        }
    },
    PLAYER_VS_PLAYER{
        public Game makeGameWithView(IView view){
            return new Game(new Human(view), new Human(view));
        }
    },
    PLAYER_VS_COMPUTER{
        public Game makeGameWithView(IView view){
            return new Game(new Human(view), new Computer(view));
        }
    },
    COMPUTER_VS_COMPUTER{
        public Game makeGameWithView(IView view){
            return new Game(new Computer(view), new Computer(view));
        }
    }
}
