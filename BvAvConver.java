import java.math.*;
public class BvAvConver {
    /*实现Bv转换Av的方法在BV1R7411y7kw*/
    public static void main(String args[]) {

        System.out.println("转换BV到AV,请按1");
        System.out.println("转换AV到BV,请按0");
        byte ConverDetecVal = 0;
        do{
            java.util.Scanner InputConver = new java.util.Scanner(System.in);//choose the converter
            ConverDetecVal = InputConver.nextByte();
            if (ConverDetecVal == 0){
                avConver();
            }else if(ConverDetecVal == 1){
                bvConver();
            }else{
                System.out.println("请重试");
            }
        }while(ConverDetecVal != 0 && ConverDetecVal != 1);
    }
    public static void bvConver() {
        System.out.println("输入BV号");
        System.out.print("BV");//输入
        
        String OriBvNo = inPutString();//input bv no
        char[] OriBvChar = OriBvNo.toCharArray();//创建char数组
        int[] OriBvInt = new int[10];//创建int数组

        for(int i = 0; i <= 9; i++){//转化bv号成数字
            OriBvInt[i] = bvDecoder(OriBvChar[i]);
        }

        BigDecimal SumBvNo = new BigDecimal("0");//定义和

        for(int i = 0; i <= 9; i++){
            SumBvNo =  SumBvNo.add(BigDecimal.valueOf(bvMulti(OriBvInt[i], i)));
        }
        BigDecimal SubBvNo = SumBvNo.subtract(new BigDecimal("100618342136696320"));//减去特定值
        BigDecimal FinalNo = xorBigDec(SubBvNo, new BigDecimal("177451812"));//与特定值异或运算

        System.out.print("BV" + OriBvNo + " 的AV号码为 AV" + FinalNo);
    }
    public static int bvDecoder(char InputChar){//最开始的bv号转数字列表
        switch(InputChar){
            case '1': return 13;
            case '2': return 12;
            case '3': return 46;
            case '4': return 31;
            case '5': return 43;
            case '6': return 18;
            case '7': return 40;
            case '8': return 28;
            case '9': return 5;
            case 'A': return 54;
            case 'B': return 20;
            case 'C': return 15;
            case 'D': return 8;
            case 'E': return 39;
            case 'F': return 57;
            case 'G': return 45;
            case 'H': return 36;
            case 'J': return 38;
            case 'K': return 51;
            case 'L': return 42;
            case 'M': return 49;
            case 'N': return 52;
            case 'P': return 53;
            case 'Q': return 7;
            case 'R': return 4;
            case 'S': return 9;
            case 'T': return 50;
            case 'U': return 10;
            case 'V': return 44;
            case 'W': return 34;
            case 'X': return 6;
            case 'Y': return 25;
            case 'Z': return 1;
            case 'a': return 26;
            case 'b': return 29;
            case 'c': return 56;
            case 'd': return 3;
            case 'e': return 24;
            case 'f': return 0;
            case 'g': return 47;
            case 'h': return 27;
            case 'i': return 22;
            case 'j': return 41;
            case 'k': return 16;
            case 'm': return 11;
            case 'n': return 37;
            case 'o': return 2;
            case 'p': return 35;
            case 'q': return 21;
            case 'r': return 17;
            case 's': return 33;
            case 't': return 30;
            case 'u': return 48;
            case 'v': return 23;
            case 'w': return 55;
            case 'x': return 32;
            case 'y': return 14;
            case 'z': return 19;
        }
        return 0;
    }
    public static char avDecoder(String InputStr){
        switch(InputStr){
            case "13": return '1';
            case "12": return '2';
            case "46": return '3';
            case "31": return '4';
            case "43": return '5';
            case "18": return '6';
            case "40": return '7';
            case "28": return '8';
            case "5": return '9';
            case "54": return 'A';
            case "20": return 'B';
            case "15": return 'C';
            case "8": return 'D';
            case "39": return 'E';
            case "57": return 'F';
            case "45": return 'G';
            case "36": return 'H';
            case "38": return 'J';
            case "51": return 'K';
            case "42": return 'L';
            case "49": return 'M';
            case "52": return 'N';
            case "53": return 'P';
            case "7": return 'Q';
            case "4": return 'R';
            case "9": return 'S';
            case "50": return 'T';
            case "10": return 'U';
            case "44": return 'V';
            case "34": return 'W';
            case "6": return 'X';
            case "25": return 'Y';
            case "1": return 'Z';
            case "26": return 'a';
            case "29": return 'b';
            case "56": return 'c';
            case "3": return 'd';
            case "24": return 'e';
            case "0": return 'f';
            case "47": return 'g';
            case "27": return 'h';
            case "22": return 'i';
            case "41": return 'j';
            case "16": return 'k';
            case "11": return 'm';
            case "37": return 'n';
            case "2": return 'o';
            case "35": return 'p';
            case "21": return 'q';
            case "17": return 'r';
            case "33": return 's';
            case "30": return 't';
            case "48": return 'u';
            case "23": return 'v';
            case "55": return 'w';
            case "32": return 'x';
            case "14": return 'y';
            case "19": return 'z';
        }
        return 'u';
    }
    public static double bvMulti(int inPutNumer, int NoOfInputNumber){
        switch(NoOfInputNumber){
            case 0: return inPutNumer*(powBigDec(58L, 6));
            case 1: return inPutNumer*(powBigDec(58L, 2));
            case 2: return inPutNumer*(powBigDec(58L, 4));
            case 3: return inPutNumer*(powBigDec(58L, 8));
            case 4: return inPutNumer*(powBigDec(58L, 5));
            case 5: return inPutNumer*(powBigDec(58L, 9));
            case 6: return inPutNumer*(powBigDec(58L, 3));
            case 7: return inPutNumer*(powBigDec(58L, 7));
            case 8: return inPutNumer*(58);
            case 9: return inPutNumer;
        }
        return 0;
    }
    public static String inPutString() {//input method
        java.util.Scanner InputStr = new java.util.Scanner(System.in);
        String StrValue = InputStr.next();
        return StrValue;
    }
    public static BigDecimal xorBigDec(BigDecimal NumberA, BigDecimal NumberB){
        return (new BigDecimal(((NumberA.toBigInteger()).xor(NumberB.toBigInteger())).toString()));
    }
    public static double powBigDec(double NumberA, int NumberB){
		return (BigDecimal.valueOf(NumberA)).pow(NumberB).doubleValue();
    }
    public static String Exchan58(String InputNum){
        BigDecimal NextInputNum = new BigDecimal(InputNum);
        //递归实现进制转换
        if(NextInputNum.compareTo(new BigDecimal("58")) != -1){
            String ReturnNum = (NextInputNum.remainder(new BigDecimal("58"))).toString();
            NextInputNum = NextInputNum.divide(new BigDecimal("58"), RoundingMode.DOWN);
            return (Exchan58((NextInputNum).toString())) + "-" + ReturnNum;
        }else{
            return (NextInputNum.remainder(new BigDecimal("58"))).toString();
        }
    }
    public static void avConver(){
        System.out.println("输入AV号");
        System.out.print("AV");
        BigDecimal OriAvNoBig = new BigDecimal(inPutString());
        BigDecimal AddAvNo = xorBigDec(OriAvNoBig, new BigDecimal("177451812"));
        BigDecimal Sum58 = AddAvNo.add(new BigDecimal("100618342136696320"));
        String TrAvNum = Exchan58((Sum58).toString());//转换成51进制
        
        String Delimeter = "-";
        String[] DivAvNum = TrAvNum.split(Delimeter);
        String DivAvNum0 = DivAvNum[0];
        DivAvNum[0] = DivAvNum[3];
        DivAvNum[3] = DivAvNum[1];
        DivAvNum[1] = DivAvNum[7];
        DivAvNum[7] = DivAvNum[2];
        DivAvNum[2] = DivAvNum[5];
        DivAvNum[5] = DivAvNum0;
        System.out.print("AV" + OriAvNoBig + " 的BV号码为 BV");
        for(int i = 0; i <= 9; i++){
            System.out.print(avDecoder(DivAvNum[i]));
        }
    }
}
