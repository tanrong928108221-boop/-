import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

    public class Studtentperformance{
        public static void main(String[] args) {
            Scanner input = new Scanner (System.in);
            int count = 0 , passCount = 0;
            double max = -1 , min = 101, total = 0 , score = 0 ;
            List<Double> scores = new ArrayList <> ();

            int excellentCount =0;
            int aPlus = 0, aMinus = 0, bCount = 0, cCount = 0, gCount = 0 , dCount = 0;

            while (true){
                System.out.println("Enter a score (-1 to quit):");

                if(!input.hasNextDouble()){
                    System.out.println("请输入数字！");
                    input.next();
                    continue;
                }

            score = input.nextDouble();
            System.out.println();

            if(score == -1){
            System.out.println("退出程序");
            break;
            }
    
            if (!isValidScore(score)){
                System.out.println("无效的分数");
                System.out.println();
                continue;
            }

        //是否及格
        System.out.println(score >= 40 ? "Pass" : "No Pass");
                   printGrade(score);
                checkHonoraryTitles(score);
                LearningSuggestions(score);
                System.out.println();

        count++;
        total += score;
        scores.add (score);
        if (score > max) max = score;
        if (score < min) min = score;
        if (score >= 40) passCount++;
        if (score >= 80) excellentCount++;

        if (score >= 99) aPlus++;
        else if (score >= 80) aMinus++;
        else if (score >= 60) bCount++;
        else if (score >= 50) cCount++;
        else if (score >= 40) dCount++;
       else gCount++;

    }

    if (count > 0){
        System.out.println("成绩报告");
        System.out.printf("有效分数：%d 个%n" , count);
        System.out.printf("总分：%.2f%n" , total);
        System.out.printf("平均分：%.2f%n" , total/count);
        System.out.printf("最高分：%.2f%n" , max);
        System.out.printf("最低分：%.2f%n" , min);
        System.out.printf("及格人数：%d%n" , passCount);
        System.out.printf("及格率：%.2f%%%n" , passCount * 100.0/ count);
        System.out.printf("优秀率（>=80) : %.2f%%%n" ,excellentCount * 100.0/count);
        System.out.printf("不及格率（<40) :%.2f%%%n" ,(count - passCount) * 100.0/count);

         // ===== 1. 中位数 =====
            Collections.sort(scores);
            int n = scores.size();
            double median;
            if (n % 2 == 1){
                median = scores.get(n/2);
            }else{
                median = (scores.get(n / 2-1) + scores.get (n / 2)) / 2.0;
            }
            System.out.printf("中位数 : %.2f%n" , median);

            // 2. 标准差 
            double mean = total / count;
            double varSum = 0;
            for (double s : scores){
                varSum += Math.pow (s - mean , 2);
            }
            double stdDev = Math.sqrt(varSum / count);
            System.out.printf("标准差 : %.2f%n" , stdDev);

            //3.分数段直方图
          int [] bins = new int [10];
          for (double s : scores) {
            int idx = (int) Math.min (s / 10 , 9);
            bins [idx]++;
          }
          System.out.println();
          System.out.println("分数段直方图");
          int i ;
          for ( i = 0 ; i < 10 ; i++);
          int low = i * 10;
          int hight = (i == 9) ? 100 : i * 10 + 9;
          System.out.printf("%3d - %3d |" , low , hight);
          for (int j = 0; j < 10; j++) System.out.println("");
          System.out.println(" " + bins [1]);

        System.out.println();
        System.out.println(" 各等级人数和占比");
        System.out.printf("A+ (99-100) : %d 人 (%.2f%%)" , aPlus , aPlus *100.0/count);
        System.out.printf("A- (80-98) : %d 人 (%.2f%%) " , aMinus , aMinus * 100.0/count);
        System.out.printf("B (60-79) : %d 人 (%.2f%%) " , bCount , bCount * 100.0/count);
        System.out.printf("C (50-69) : %d 人 (%.2f%%) " , cCount , cCount *100.0/count );
        System.out.printf("D (4049) : %d 人(%.2f%%) " , dCount , dCount *100.0/count);
        System.out.printf("G (0-39) : %d 人 (%.2f%%) ", gCount , gCount * 100.0/count);

    }else{
        System.out.println("没有输入任何有效分数");
            }
            input.close();
        }

        //分数有A,B,C,D,G
            public static void printGrade (double score){
            if (score >= 99){
                System.out.println("A+");
            }else if(score >= 80 ){
                System.out.println("A-");
            }else if (score >= 60){
                System.out.println("B");
            }else if (score >= 50){
                System.out.println("C");
            }else if (score >= 40){
                System.out.println("D");
            }else if (score >= 0){
                System.out.println("G");
            }
        }

            public static void checkScore (double score){
            if (score < 0){
            System.out.println ("Enter numbers with a score not exceeding 100 and not negative number");

            }else if (score >= 100 ){
                System.out.println("Does not exist");
            }else{
                System.out.println("exist");
                }
            }

            //分数称号
            public static void checkHonoraryTitles (double score){
                if (score < 0){
                System.out.println("Enter title check Honorary Titles");
                
            }else if (score >= 99){
                System.out.println("状元郎");
            }else if (score >= 80){
                System.out.println("榜眼");
            }else if (score >= 60){
                System.out.println("进士");
            }else if (score >= 50){
                System.out.println("优秀学生干部");
            }else if (score >= 40){
                System.out.println("秀才");
            }else if (score >= 0){
                System.out.println("落榜生");
                
                }
            }

            //分数鼓励
            public static void LearningSuggestions(double score) {
                if (score < 0){
                    System.out.println("Enter title check a Learning Suggestions");

                }else if (score >= 80 ){
                    System.out.println("Execellent work , keep if up");
                }else if (score >= 60){
                    System.out.println("Pass , keep improving");
                }else if (score >= 40){
                    System.out.println("Need more pratice");
                }else if (score >= 0){
                    System.out.println("waste");
                    }
                }
                
                public static boolean isValidScore (double score){
                        return score >= 0 && score <= 100; 
                }
            }
        
    
                
              
            
                
            
            

