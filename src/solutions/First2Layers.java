package solutions;
import javax.swing.*;
import moves.Moves;

//复原底层及中间层
public class First2Layers extends Solution{
    String target;

    public First2Layers(JPanel panel,int[][] color){
        super(panel,color);
    }

    //此方法在不影响其他底层角块的情况下，将目标面所在角块移动到{F0,A8,B6}，保证目标面移动到F0
    void conorToF0(String target){
        switch(target){
            case "F0":break;
            case "A0":{
                Moves.perform("u R U r",delay);
                break;
            }
            case "A2":{
                Moves.perform("U R u r",delay);
                break;
            }
            case "B0":{
                Moves.perform("R U r",delay);
                break;
            }
            case "B2":{
                Moves.perform("U U R u r",delay);
                break;
            }
            case "C0":{
                Moves.perform("U R U r",delay);
                break;
            }
            case "C2":{
                Moves.perform("u R u r",delay);
                break;
            }
            case "D0":{
                Moves.perform("u u R U r",delay);
                break;
            }
            case "D2":{
                Moves.perform("R u r",delay);
                break;
            }
            case "E0":{
                Moves.perform("R U r U R u r",delay);
                break;
            }
            case "E2":{
                Moves.perform("u R U r U R u r",delay);
                break;
            }
            case "E6":{
                Moves.perform("U R U r U R u r",delay);
                break;
            }
            case "E8":{
                Moves.perform("R U U r u R U r",delay);
                break;
            }
            case "F2":{
                Moves.perform("l u L R U r",delay);
                break;
            }
            case "F6":{
                Moves.perform("r U R U U R u r",delay);
                break;
            }
            case "F8":{
                Moves.perform("L u u l U R u r",delay);
                break;
            }
            case "A6":{
                Moves.perform("l U L u R U r",delay);
                break;
            }
            case "A8":{
                Moves.perform("R u r U R u r",delay);
                break;
            }
            case "B6":{
                Moves.perform("R U r u R U r",delay);
                break;
            }
            case "B8":{
                Moves.perform("r U U R R u r",delay);
                break;
            }
            case "C6":{
                Moves.perform("r U R U R U r",delay);
                break;
            }
            case "C8":{
                Moves.perform("L u l u R u r",delay);
                break;
            }
            case "D6":{
                Moves.perform("L u u l R U r",delay);
                break;
            }
            case "D8":{
                Moves.perform("l u L U R u r",delay);
                break;
            }
            default:System.out.println("Error in method 'conorToF0'.");
        }
    }

    //此方法在不影响其他中间层棱块的情况下，将目标面所在棱块移动到{A5,B3}，保证目标面移动到A5
    void edgeToA5(String target){
        switch(target){
            case "A5":break;
            case "A1":{
                Moves.perform("U R u r u f U F", delay);
                break;
            }
            case "B1":{
                Moves.perform("U U R u r u f U F", delay);
                break;
            }
            case "C1":{
                Moves.perform("u R u r u f U F", delay);
                break;
            }
            case "D1":{
                Moves.perform("R u r u f U F", delay);
                break;
            }
            case "E1":{
                Moves.perform("U r f R U R u r F", delay);
                break;
            }
            case "E3":{
                Moves.perform("u u r f R U R u r F", delay);
                break;
            }
            case "E5":{
                Moves.perform("r f R U R u r F", delay);
                break;
            }
            case "E7":{
                Moves.perform("u r f R U R u r F", delay);
                break;
            }
            case "B3":{
                Moves.perform("r f R U R u r F u R u r u f U F", delay);
                break;
            }
            case "B5":{
                Moves.perform("p r f R U R u r F P U r f R U R u r F", delay);
                break;
            }
            case "C3":{
                Moves.perform("p r f R U R u r F P u R u r u f U F", delay);
                break;
            }
            case "C5":{
                Moves.perform("p p r f R U R u r F p p U r f R U R u r F", delay);
                break;
            }
            case "D3":{
                Moves.perform("p p r f R U R u r F p p u R u r u f U F", delay);
                break;
            }
            case "D5":{
                Moves.perform("P r f R U R u r F p U r f R U R u r F", delay);
                break;
            }
            case "A3":{
                Moves.perform("P r f R U R u r F p u R u r u f U F", delay);
                break;
            }
            default:{;}
        }
    }
    
    public void run(){
        direct();
        //检查前序步骤是否完成，若未完成不执行还原，并弹出提醒消息
        if(  color[5][1]!=BLACK || color[5][3]!=BLACK || color[5][5]!=BLACK || color[5][7]!=BLACK ||
             color[0][7]!=BLUE  || color[1][7]!=RED   || color[2][7]!=GREEN || color[3][7]!=ORANGE){
            JOptionPane.showMessageDialog(panel, "请先还原黑色十字哦！", "您跳步了",JOptionPane.WARNING_MESSAGE); 
        }
        else{
            stall(1000);
            //还原底层四角块
            if( color[5][0]!=BLACK || color[5][2]!=BLACK || color[5][6]!=BLACK || color[5][8]!=BLACK ||    //判断是否跳步，false则跳步
                color[0][8]!=BLUE  || color[0][6]!=BLUE  || color[2][8]!=GREEN || color[2][6]!=GREEN){
                    target = findConor(BLACK, BLUE);
                    conorToF0(target);
                    stall(500+delay/2);
                    
                    //借位法
                    Moves.perform("p", delay);
                    target = findConor(BLACK, RED);
                    conorToF0(target);
                    stall(500+delay/2);

                    Moves.perform("p", delay);
                    target = findConor(BLACK, GREEN);
                    conorToF0(target);
                    stall(500+delay/2);

                    Moves.perform("p", delay);
                    target = findConor(BLACK, ORANGE);
                    conorToF0(target);
                    Moves.perform("p", delay);
                    stall(300+delay);
                }

            //还原中间层四棱块 
            if( color[0][3]!=BLUE  || color[0][5]!=BLUE  || color[1][3]!=RED    || color[1][5]!=RED    ||   //判断是否跳步，false则跳步
                color[2][3]!=GREEN || color[2][5]!=GREEN || color[3][3]!=ORANGE || color[3][5]!=ORANGE){

                    target = findEdge(BLUE, RED);
                    edgeToA5(target);
                    stall(500+delay/2);

                    //借位法
                    Moves.perform("p",delay);
                    stall(200);
                    target = findEdge(RED, GREEN);
                    edgeToA5(target);
                    stall(500+delay/2);

                    Moves.perform("p",delay);
                    stall(200);
                    target = findEdge(GREEN, ORANGE);
                    edgeToA5(target);
                    stall(500+delay/2);
                    
                    Moves.perform("p",delay);
                    stall(200);
                    target = findEdge(ORANGE, BLUE);
                    edgeToA5(target);
                    Moves.perform("p",delay);
            }
        }   
    }
    
}
