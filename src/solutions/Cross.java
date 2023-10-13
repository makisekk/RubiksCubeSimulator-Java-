package solutions;
import javax.swing.JPanel;
import moves.Moves;

//复原底层的四个棱块
public class Cross extends Solution{
    String target;

    public Cross(JPanel panel,int[][] color){
        super(panel,color);
    }

    //此方法在不影响其他底层棱块的情况下，将目标面所在棱块移动到{F3,B7}，保证目标面移动到F3
    void edgeToF3(String target){
        switch(target){
            case "F3":break;
            case "A1":{
                Moves.perform("s u S",delay);
                break;
            }
            case "B1":{
                Moves.perform("U s u S",delay);
                break;
            }
            case "C1":{
                Moves.perform("u u s u S",delay);
                break;
            }
            case "D1":{
                Moves.perform("u s u S",delay);
                break;
            }
            case "A3":{
                Moves.perform("F F r F F",delay);
                break;
            }
            case "A5":{
                Moves.perform("r",delay);
                break;
            }
            case "B3":{
                Moves.perform("d F D",delay);
                break;
            }
            case "B5":{
                Moves.perform("B U b r r",delay);
                break;
            }
            case "C3":{
                Moves.perform("r r r",delay);
                break;
            }
            case "C5":{
                Moves.perform("L u u l r r",delay);
                break;
            }
            case "D3":{
                Moves.perform("L u l s u S",delay);
                break;
            }
            case "D5":{
                Moves.perform("F u f r r",delay);
                break;
            }
            case "E1":{
                Moves.perform("U r r",delay);
                break;
            }
            case "E3":{
                Moves.perform("u u r r",delay);
                break;
            }
            case "E5":{
                Moves.perform("r r",delay);
                break;
            }
            case "E7":{
                Moves.perform("u r r",delay);
                break;
            }
            case "F1":{
                Moves.perform("F F u r r",delay);
                break;
            }
            case "F5":{
                Moves.perform("l l u u r r",delay);
                break;
            }
            case "F7":{
                Moves.perform("B B U r r",delay);
                break;
            }
            case "A7":{
                Moves.perform("f r",delay);
                break;
            }
            case "B7":{
                Moves.perform("R R U s u S",delay);
                break;
            }
            case "C7":{
                Moves.perform("B B s U S",delay);
                break;
            }
            case "D7":{
                Moves.perform("l l u s u S",delay);
                break;
            }
            default:System.out.println("Error in method 'edgeToF3'.");
        }
    }

    public void run(){
        direct();
        stall(300+delay);
        if(color[0][7]!=BLUE  || color[1][7]!=RED   || color[2][7]!=GREEN || color[3][7]!=ORANGE ||   //若底层十字已复原，则无需执行
           color[5][1]!=BLACK || color[5][3]!=BLACK || color[5][5]!=BLACK || color[5][7]!=BLACK  ){
            //复原黑红棱块   
            target = findEdge(BLACK,RED);
            edgeToF3(target);
            stall(300+delay);

            //用借位法依次复原黑绿、黑橙、黑蓝棱块
            Moves.perform("d",delay);
            stall(200);
            target = findEdge(BLACK,GREEN);
            edgeToF3(target);
            stall(300+delay);

            Moves.perform("d",delay);
            stall(200);
            target = findEdge(BLACK,ORANGE);
            edgeToF3(target);
            stall(300+delay);

            Moves.perform("d",delay);
            stall(200);
            target = findEdge(BLACK,BLUE);
            edgeToF3(target);
            Moves.perform("d",delay);
        
        }
    }
}
