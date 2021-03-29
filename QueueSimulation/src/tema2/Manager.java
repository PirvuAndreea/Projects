package tema2;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Manager extends Thread{

    private String outFile;
 
    private int nrclients =1000;
    private int nrOfCheckouts =50 ;
    private int runTime=1000;
    private int maxArrivalTime=1000;
    private int minArrivalTime=1;
    private int minProcessingWait=1;
    private int maxProcessingWait=1000;
    private double avg=0;
    private int sum=0;

    private Queue[] queue = new Queue[nrOfCheckouts];
    private Client[] vect_clienti = new Client[nrclients];
    private Client[] queue_wait = new Client[nrclients];
    private int[] queuenr = new int[nrOfCheckouts];
    private Client[][] que = new Client[nrclients][nrOfCheckouts];
    //private Client[][] qq = new Client[nrclients][nrOfCheckouts];
    //private Checkout[] ww = new Checkout[nrOfCheckouts];
    Thread[] thread = new Thread[201];

    public Queue[] getQueue() {
        return queue;
    }

    public void setQueue(Queue[] queue) {
        this.queue = queue;
    }


    public void Read(String inFile){
        Scanner scan = null ;

        try {
            // "D:\\An2_sem2_exerc\\TP\\Tema2_TP\\in-test-1.txt"
            //File file = new File("D:\\An 2, sem 2 exerc\\TP\\1Pop\\In-Test.txt");
            scan = new Scanner (new File(inFile));
        }
        catch(Exception e) {
            System.out.println("Could not find file to read");
        }

        nrclients = scan.nextInt();
        nrOfCheckouts = scan.nextInt();
        runTime=scan.nextInt();
        String[] token = scan.next().split(",");
        minArrivalTime = Integer.parseInt(token[0]);
        maxArrivalTime = Integer.parseInt(token[1]);
        String[] token2 = scan.next().split(",");
        maxProcessingWait = Integer.parseInt(token2[0]);
        maxProcessingWait = Integer.parseInt(token2[1]);

        scan.close();


        for(int i=0;i<nrOfCheckouts;i++){
            queue[i] = new Queue(i);
            thread[i] = new Thread(queue[i]);
            thread[i].start();
        }


    }



    public Manager(String inFile, String outFile){
        //fileWrite("\n\n");
    this.outFile = outFile;
        Read(inFile);
		/*
		for(int i=0;i<nrOfCheckouts;i++){
			queue[i] = new Checkout(i);
			thread[i] = new Thread(queue[i]);
			thread[i].start();
		}
		*/
    }

    public void fileWrite(String s, String outFile){
        try( //FileWriter fw = new FileWriter("out-test-1.txt", true);
             FileWriter fw = new FileWriter(outFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)){
            out.println(s);
        }

        catch (IOException e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }
    }



    public int randomProcessingClient(){
        return (1+(int)(Math.random()*(nrclients)));
    }

    public int randomProcessingArrivalTime(){
        return (minArrivalTime+(int)(Math.random()*(maxArrivalTime-minArrivalTime)));
    }

    public int randomProcessingWait(){
        return (2+(int)(Math.random()*(maxProcessingWait-minProcessingWait)));
    }


    int maxim(int a, int b) {
        if(a>b) {
            return a;
        }
        else {
            return b;
        }
    }



    public int leastPopulatedQueue(){
        int min=99999;
        int index=0;
        int[] a=new int[nrOfCheckouts];
        for(int i=0;i<nrOfCheckouts;i++){
            a[i]=queue[i].getQueueSize();
        }
        for(int i=0;i<nrOfCheckouts;i++){
            if(min>a[i]){
                min=a[i];
                index=i;
            }
        }
        return index;
    }


    int average_linie(Client[][] a, int clienti, int cozi, int timp) {
        for(int i=0; i<clienti; i++) {
            for(int j=0; j<cozi; j++) {
                if(a[i][j].getArrivet()==timp) {
                    return i;
                }
            }
        }
        return -15;
    }

    int average_col(Client[][] a, int clienti, int cozi, int timp) {
        for(int i=0; i<clienti; i++) {
            for(int j=0; j<cozi; j++) {
                if(a[i][j].getWaitingt()==timp) {
                    return j;
                }
            }
        }
        return -16;
    }


    int indexx_linie(Client[][] a, int clienti, int cozi) {
        for(int i=0; i<clienti; i++) {
            for(int j=0; j<cozi; j++) {
                if(a[i][j].getWaitingt()==1) {
                    return i;
                }
            }
        }
        return -5;
    }

    int indexx_col(Client[][] a, int clienti, int cozi) {
        for(int i=0; i<clienti; i++) {
            for(int j=0; j<cozi; j++) {
                if(a[i][j].getWaitingt()==1) {
                    return j;
                }
            }
        }
        return -6;
    }


    @Override
    public void run() {

        //System.out.println("nr clienti = "+nrclients);

        for(int i=0; i<nrclients; i++) {
            for(int j=0; j<nrOfCheckouts; j++) {
                queuenr[j] = 0;
                que[i][j] = new Client(0, 0, 0);
            }
        }

        fileWrite("Time 0", this.outFile);
        fileWrite("Waiting clients:", this.outFile);
        System.out.println("Time 0");
        System.out.println("Waiting clients:");
        // punem clienti in Waiting clients
        for(int j=0; j<nrclients; j++) {
            Client c = new Client( (j+1) ,randomProcessingArrivalTime(), randomProcessingWait() );
            c.setId(j+1);
            vect_clienti[j] = c;
            queue_wait[j] = c;
            sum = sum + c.getWaitingt();
            fileWrite ( "("+ (j+1) +","+c.getArrivet()+","+c.getWaitingt()+")", this.outFile );
            System.out.println( "("+ (j+1) +","+c.getArrivet()+","+c.getWaitingt()+")" );
        }
        // cozi inchise, sunt vide
        for(int j=0; j<nrOfCheckouts; j++) {
            if(queuenr[j]==0) {
                fileWrite( "Queue "+(j+1)+": closed", this.outFile );
                System.out.println("Queue "+(j+1)+": closed");
            }
        }

        int currentTime=1;
        int nr=0, okay=0, poz=0, nr2=-5, poz2=0, iesiri=0, nr3=-5;

        while(currentTime<runTime){
            fileWrite("\n", this.outFile);
            fileWrite("Time "+currentTime, this.outFile);
            fileWrite("Waiting clients: ", this.outFile);
            System.out.println("Time "+currentTime);
            System.out.println("Waiting clients: ");

            for(int j=0; j<nrclients; j++) {
                okay=0;




                for(int jj=0; jj<nrOfCheckouts; jj++) {
                    if( (queue_wait[j].getArrivet() == currentTime) && (okay==0) ) {
                        // il pun in noua queue
                        //que[poz][nr] = vect_clienti[j];
                        que[poz][nr] = queue_wait[j];
                        queuenr[nr]++;
                        //ww[nr].addClient(vect_clienti[j]);
                        nr++;
                        okay=1;
                        iesiri++;
                        //ww[nr].addClient(vect_clienti[j]);
                    }
                    if(nr == nrOfCheckouts) {
                        nr = 0;
                        poz++;
                        poz2++;
                    }
                }

            }


            for(int j=0; j<nrclients; j++) {
                nr2 = indexx_col(que, nrclients, nrOfCheckouts);
                nr3 = indexx_linie(que, nrclients, nrOfCheckouts);
                if( queue_wait[j].getWaitingt()==1 ) {
                    queuenr[nr2]--;
                    queue_wait[j].setWaitingTime(-2);
                    iesiri++;
                }
            }


            for(int j=0; j<nrclients; j++) {
                // Decrementam cu 1 Waiting Time
                if( (queue_wait[j].getArrivet() < currentTime)&&(queue_wait[j].getWaitingt()>1) ) {
                    // daca are arriv time bun si waiting bun scadem 1 din waiting time
                    queue_wait[j].setWaitingTime(queue_wait[j].getWaitingt()-1); //
                }
                // cei care sunt in Waiting
                if( (queue_wait[j].getWaitingt()>=1) && ( queue_wait[j].getArrivet()>currentTime) ){
                    // cei care au waiting bun, dar nu au arrival time pt a fi scosi din asteptare
                    fileWrite( "("+ (j+1) +","+queue_wait[j].getArrivet()+","+
                            queue_wait[j].getWaitingt()+")", this.outFile );

                    System.out.println( "("+ (j+1) +","+queue_wait[j].getArrivet()+","+
                            queue_wait[j].getWaitingt()+")" );
                }

            }

			/*
			//fileWrite("cozile");
			System.out.println("cozile");
			for(int m=0; m<nrOfCheckouts; m++) {
				//fileWrite("Q"+(m+1)+" are "+ queuenr[m]+" clnts, nr="+nr+
					//	" nr2="+nr2+" nr3="+nr3+", iesiri="+iesiri+" poz2="+poz2);

				System.out.println("Q"+(m+1)+" are "+ queuenr[m]+" clienti");
			}
			*/

            for(int j=0; j<nrOfCheckouts; j++) {
                int lll=0;
                //coada e vida
                if(queuenr[j]==0  ) {
                    fileWrite("Queue "+(j+1)+": closed", this.outFile);
                    System.out.println("Queue "+(j+1)+": closed");
                }
                // coada nu e vida
                else if( (queuenr[j]>0)  ) {
                    fileWrite("Queue "+ (j+1), this.outFile);
                    System.out.println("Queue "+ (j+1));
                    while(lll < nrclients ) {
                        if(que[lll][j].getWaitingt()>0) {
                            fileWrite("("+que[lll][j].getID()+","+
                                    que[lll][j].getArrivet()+","+que[lll][j].getWaitingt()+")", this.outFile);

                            System.out.println("("+que[lll][j].getID()+","+
                                    que[lll][j].getArrivet()+","+que[lll][j].getWaitingt()+")");
                        }
                        lll++;
                    }
                }
            }

            try {
                Thread.sleep(100);
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentTime++;
        }


        avg = ((double) sum)/nrclients;
        fileWrite("\n", this.outFile);
        fileWrite("Average Waiting time="+avg, this.outFile);
        System.out.println("\n\nAverage Waiting time="+avg);

        System.exit(0);
    }

}


