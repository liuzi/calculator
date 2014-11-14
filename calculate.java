import java.util.Stack;

/**
 * Created by jiangliu on 14-11-14.
 */
public class calculate {
    private StringBuffer display=new StringBuffer("128+6*(5+2)/3");
    String numqueue[];//shuzi duilie
    private boolean dot=false;//panduan shifou shuru xiaoshu
    Stack<String> sk = new Stack<String>();
    int j=0;//queue index

    public int prior(char a){
        switch (a){
            case '+':
            case '-':
                return 2;
            case '*':
            case '/':
                return 3;
            case '(':
            case ')':
                return 1;
            default:
                return 0;
        }
    }
    public void cal_numbers(){
        int top=0;
        int tail=0;
        Double result;
        for(int i=1;i<j;i++){
            switch (numqueue[i]){
                case "+":
                    result=Double.valueOf(numqueue[i-2])+Double.valueOf(numqueue[i-1]);
            }
        }
    }
    public void io_stack(char a){
        String b="";
        if(sk.isEmpty()){
            sk.push("#");
        }
        if(a=='('){
            sk.push(b+a);
        }
        else{
            //dangqian yunsuanfu youxianji dayu zhanding yuansu ze jinzhan
            if(prior(a)>=prior(sk.peek().charAt(0))&&sk.peek()!="("){
                sk.push(b+a);
            }
            //dangqian yunsuanfu youxianji xiaoyu zhanding yunsuanfu ze zhanding yuansu chuzhan
            else if(prior(a)<prior(sk.peek().charAt(0))){
                numqueue[j++]=sk.pop();
                io_stack(a);//yu zhan de xiayige yunsuanfu jinxing bijiao
            }
            else if(prior(a)==prior(sk.peek().charAt(0))) {
                if (a == ')') {
                    sk.pop();
                }
                else if(a=='#'){
                    sk.pop();
                    cal_numbers();
                }
            }
        }



    }
    //duru shuru neirong
    public  void read(){
        String num="";

        for(int i=0;i<display.length();i++){
            char a=display.charAt(i);
            if(a>='0'&&a<='9'&&a=='.'){
                num+=a;
            }
            else{
                numqueue[j++]=num;
                io_stack(a);
                num="";
            }

            }

        }
    }

}
