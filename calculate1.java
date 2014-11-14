import java.util.Stack;

/**
 * Created by jiangliu on 14-11-14.
 */

public class calculate {
    private StringBuffer display=new StringBuffer("128+6*(5+2)/3");
    //boolean tag[];
    String numqueue[];//shuzi duilie
    Double result;
    private boolean dot=false;//panduan shifou shuru xiaoshu
    Stack<String> sk = new Stack<String>();
    Stack<Double> number=new Stack<Double>();
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
        double num1=0;
        double num2=0;
        for(int i=0;i<j;i++){
            if(numqueue[i]=="+"||numqueue[i]=="-"||numqueue[i]=="*"||numqueue[i]=="/") {
                num1 = number.pop();
                num2 = number.pop();
                switch (numqueue[i].charAt(0)) {
                    case '+':
                        number.push(num2 + num1);
                        break;
                    case '-':
                        number.push(num2 - num1);
                        break;
                    case '*':
                        number.push(num2 * num1);
                        break;
                    case '/':
                        if (num2 == 0) {
                            System.out.println("0 buneng zuo chu shu");//tishikuang textview
                        } else {
                            number.push(num2 / num1);
                        }
                }
            }
            else {
                number.push(Double.valueOf(numqueue[i]));
            }
          }
        result=number.pop();
        System.out.println(result);
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
                //numqueue[j++]=sk.pop();
                //tag[j]=false;
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
                //queue.offer(num);
                numqueue[j++]=num;
                //tag[j]=false;
                io_stack(a);
                num="";
            }
        }
    }


}
