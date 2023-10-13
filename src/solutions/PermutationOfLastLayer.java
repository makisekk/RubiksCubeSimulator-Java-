package solutions;
import javax.swing.*;
import moves.Moves;

//还原顶层块排列，即将顶层的角块、棱块调换到正确的位置
public class PermutationOfLastLayer extends Solution{

    public PermutationOfLastLayer(JPanel panel,int[][] color){
        super(panel,color);
    }
    
    public void run(){
        direct();
        //检查前序步骤是否完成，若未完成不执行还原，并弹出提醒消息
        boolean isReady = true;
        //检查四个侧面的前两层
        for(int i=0;i<4;i+=1){
            for(int j=3;j<9;j+=1){
                if(color[i][j]!=i){
                    isReady = false;
                    break;
                }
            }
            if(!isReady)
                break;
        }
        //检查顶面和底面
        for(int j=0;j<9;j+=1){
            if((color[BLACK][j]!=BLACK) || (color[YELLOW][j]!=YELLOW)){
                isReady = false;
                break;
            }
        } 
        if(!isReady){
            JOptionPane.showMessageDialog(panel, "请先还原黑色底的前两层和顶面哦！", "您跳步了",JOptionPane.WARNING_MESSAGE); 
        }
        else{
            //判断顶层四角块的状态
            //对应图示请参考设计文档
            state = 0;
            for(int i=0;i<4;i+=1){
                if((color[3][0] == color[3][2]) && (color[0][0] == color[0][2])){
                    state = 3;
                }    
                else if((color[3][0] == color[3][2]) && (color[0][0] != color[0][2])){
                    state = 1;
                }    
                else if((color[3][0] != color[3][2]) && (color[0][0] != color[0][2]) 
                     && (color[1][0] != color[1][2]) && (color[2][0] != color[2][2])){
                    state = 2;
                }                             
                //若皆不匹配，顶层旋转90°重新匹配
                if(state==0)
                    Moves.perform("U",delay);
                else 
                    break;
            }
            stall(200+delay);

            //还原顶层四角块相对位置关系
            switch(state){
                case 3:break;
                case 1:{
                    Moves.perform(" R U r u r F R R u r u R U r f", delay);
                    break;
                }
                case 2:{
                    Moves.perform("F R u r u R U r f R U r u r F R f",delay);
                    break;
                }
                default:System.out.println("Error in PLL method 'run'.");
            }
            stall(300+delay);

            //判断顶层四棱块的状态
            //对应图示请参考设计文档
            state = 0;  
            for(int i=0;i<4;i+=1){
                if((color[0][0] == color[0][1]) && (color[1][0] == color[1][1])){
                    state = 5;
                }         
                else if((color[0][2] == color[1][1]) && (color[3][2] == color[0][1])){
                    state = 1;
                }     
                else if((color[0][1] == color[1][0]) && (color[3][1] == color[0][0])){
                    state = 2;
                }       
                else if((color[0][2] == color[1][1]) && (color[0][1] == color[1][0])){
                    state = 3;
                }                                       
                else if((color[0][0] == color[2][1]) && (color[0][1] == color[2][0])){
                    state = 4;
                }     
                //若皆不匹配，顶层旋转90°重新匹配  
                if(state==0)
                    Moves.perform("U",delay);
                else 
                    break;
            }
            stall(200+delay);

            //还原所有顶层块相对位置
            switch(state){
                case 5:break;
                case 1:{
                    Moves.perform("R R U R U r u r u r U r", delay);
                    break;
                }
                case 2:{
                    Moves.perform("R u R U R U R u r u r r",delay);
                    break;
                }
                case 3:{
                    Moves.perform("U r u R u R U R u r U R U R R u r U",delay);
                    break;
                }
                case 4:{
                    Moves.perform(" m m U m m U U m m U m m", delay);
                    break;
                }
                default:System.out.println("Error in PLL method 'run'.");
            }
            stall(300+delay);

            //还原顶层绝对位置
            if(color[0][0]!=BLUE){
                if(color[1][0]==BLUE){
                    Moves.perform("U",delay);
                }
                else if(color[2][0]==BLUE){
                    Moves.perform("U U",delay);
                }    
                else if(color[3][0]==BLUE){
                    Moves.perform("u",delay);
                }    
            }
        }    
    }
}
