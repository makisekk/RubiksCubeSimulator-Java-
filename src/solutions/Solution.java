package solutions;
import javax.swing.JPanel;

import moves.Moves;

//此类为四大复原步骤的父类，包含它们共有的成员变量和方法
public class Solution {
    int state;                  //用于一部分需要分情况处理的场合，給各种情况编号
    JPanel panel;               
    public long delay = 100;    //魔方每次转动之间的延时基础值，单初始化为100ms，可以通过图形界面的菜单栏修改
    int[][] color;              //魔方状态
    public static final int BLUE   = 0; //常量定义
    public static final int RED    = 1;
    public static final int GREEN  = 2;
    public static final int ORANGE = 3;
    public static final int YELLOW = 4;
    public static final int BLACK  = 5;

    public Solution(JPanel panel,int[][] color){
        this.panel = panel;
        this.color = color;
    }

    //此方法为线程延时的封装
    public void stall(long millisecond){
        try{
            Thread.sleep(millisecond);
        }
        catch(Exception e){
            ;
        }
    }

    //此方法调整魔方朝向，将黑色中心块置于底面，蓝色中心块置于正面
    public void direct(){
        if(color[0][4]==BLACK){
            Moves.perform("y",delay);
        }
        else if(color[1][4]==BLACK){
            Moves.perform("F S b");
            stall(1000);
        }
        else if(color[2][4]==BLACK){
            Moves.perform("Y",delay);
        }
        else if(color[3][4]==BLACK){
            Moves.perform("f s B");
            stall(1000);
        }
        else if(color[4][4]==BLACK){
            Moves.perform("y y",delay);
        }
        else ;
        
        if(color[0][4]==BLUE) ;
        else if(color[1][4]==BLUE){
            Moves.perform("X",delay);
        }
        else if(color[2][4]==BLUE){
            Moves.perform("X X",delay);
        }
        else if(color[3][4]==BLUE){
            Moves.perform("x",delay);
        }
        else System.out.println("Error in method 'direct'.");
    }

    //此方法寻找颜色为{b1_color,b2_color}的棱块，返回b1_color对应的色块位置
    public String findEdge(int b1_color,int b2_color){
        if(color[0][1]==b1_color){
            if(color[4][7]==b2_color){
                return "A1";           
            }
        }               
        if(color[4][7]==b1_color){
            if(color[0][1]==b2_color){
                return "E7";           
            }
        }
        if(color[0][3]==b1_color){
            if(color[3][5]==b2_color){
                return "A3";           
            }
        }
        if(color[3][5]==b1_color){
            if(color[0][3]==b2_color){
                return "D5";
            }
        }
        if(color[0][5]==b1_color){
            if(color[1][3]==b2_color){
                return "A5";
            }
        }     
        if(color[1][3]==b1_color){
            if(color[0][5]==b2_color){
                return "B3";
            }
        }
        if(color[0][7]==b1_color){
            if(color[5][1]==b2_color){
                return "A7";
            }
        }
        if(color[5][1]==b1_color){
            if(color[0][7]==b2_color){
                return "F1";
            }
        }
        if(color[2][1]==b1_color){
            if(color[4][1]==b2_color){
                return "C1";
            }
        }
        if(color[4][1]==b1_color){
            if(color[2][1]==b2_color){
                return "E1";
            }
        }
        if(color[2][3]==b1_color){
            if(color[1][5]==b2_color){
                return "C3";
            }
        }
        if(color[1][5]==b1_color){
            if(color[2][3]==b2_color){
                return "B5";
            }
        }
        if(color[2][5]==b1_color){
            if(color[3][3]==b2_color){
                return "C5";
            }
        }
        if(color[3][3]==b1_color){
            if(color[2][5]==b2_color){
                return "D3";
            }
        }
        if(color[2][7]==b1_color){
            if(color[5][7]==b2_color){
                return "C7";
            }
        }
        if(color[5][7]==b1_color){
            if(color[2][7]==b2_color){
                return "F7";
            }
        }
        if(color[4][5]==b1_color){
            if(color[1][1]==b2_color){
                return "E5";
            }
        }
        if(color[1][1]==b1_color){
            if(color[4][5]==b2_color){
                return "B1";
            }
        }
        if(color[4][3]==b1_color){
            if(color[3][1]==b2_color){
                return "E3";
            }
        }
        if(color[3][1]==b1_color){
            if(color[4][3]==b2_color){
                return "D1";
            }
        }
        if(color[5][3]==b1_color){
            if(color[1][7]==b2_color){
                return "F3";
            }
        }
        if(color[1][7]==b1_color){
            if(color[5][3]==b2_color){
                return "B7";
            }
        }
        if(color[5][5]==b1_color){
            if(color[3][7]==b2_color){
                return "F5";
            }
        }
        if(color[3][7]==b1_color){
            if(color[5][5]==b2_color){
                return "D7";
            }
        }       
        System.out.println("Error in method 'findEdge'.");
        return "";     
    }

    //此方法寻找颜色为{b1_color,b2_color,b3_color}(必须按顺时针顺序)的角块，返回b1_color对应的色块位置
    //每个角块有三个色块b1,b2,b3，但存在约束 “从顺时针方向看，b2是b1的下一个面，b3是b2的下一个面,b1是b3的下一个面” ，只需验证b1,b2的颜色就能锁定特定的角块
    public String findConor(int b1_color,int b2_color){
        if(color[0][0]==b1_color && color[3][2]==b2_color){
            return "A0";
        }    
        else if(color[3][2]==b1_color && color[4][6]==b2_color){
            return "D2";
        }    
        else if(color[4][6]==b1_color && color[0][0]==b2_color){
            return "E6";
        }    
        else if(color[0][2]==b1_color && color[4][8]==b2_color){
            return "A2";
        }    
        else if(color[4][8]==b1_color && color[1][0]==b2_color){
            return "E8";
        }    
        else if(color[1][0]==b1_color && color[0][2]==b2_color){
            return "B0";
        }    
        else if(color[1][2]==b1_color && color[4][2]==b2_color){
            return "B2";
        }    
        else if(color[4][2]==b1_color && color[2][0]==b2_color){
            return "E2";
        }    
        else if(color[2][0]==b1_color && color[1][2]==b2_color){
            return "C0";
        }    
        else if(color[2][2]==b1_color && color[4][0]==b2_color){
            return "C2";
        }    
        else if(color[4][0]==b1_color && color[3][0]==b2_color){
            return "E0";
        }    
        else if(color[3][0]==b1_color && color[2][2]==b2_color){
            return "D0";
        }    
        else if(color[0][6]==b1_color && color[5][2]==b2_color){
            return "A6";
        }
        else if(color[5][2]==b1_color && color[3][8]==b2_color){
            return "F2";
        }    
        else if(color[3][8]==b1_color && color[0][6]==b2_color){
            return "D8";
        }    
        else if(color[0][8]==b1_color && color[1][6]==b2_color){
            return "A8";
        }    
        else if(color[1][6]==b1_color && color[5][0]==b2_color){
            return "B6";
        }    
        else if(color[5][0]==b1_color && color[0][8]==b2_color){
            return "F0";
        }    
        else if(color[1][8]==b1_color && color[2][6]==b2_color){
            return "B8";
        }    
        else if(color[2][6]==b1_color && color[5][6]==b2_color){
            return "C6";
        }    
        else if(color[5][6]==b1_color && color[1][8]==b2_color){
            return "F6";
        }    
        else if(color[2][8]==b1_color && color[3][6]==b2_color){
            return "C8";
        }    
        else if(color[3][6]==b1_color && color[5][8]==b2_color){
            return "D6";
        }    
        else if(color[5][8]==b1_color && color[2][8]==b2_color){
            return "F8";
        }    
        else{
            System.out.println("Error in method 'findConor'.");
            return "";
        }
    }
}
