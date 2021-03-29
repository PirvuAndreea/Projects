package tema2;


import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Queue extends Thread{
	 private ArrayList <Client> q = new ArrayList<>();
	    private BlockingQueue<Client> queue = new ArrayBlockingQueue<Client>(12345);

	    private int nr_queue;
	    private int nrclients;
	    private int runTime;
	    private int maxArrivalTime;
	    private int minArrivalTime;
	    private int minProcessingWait;
	    private int maxProcessingWait;

	    public Queue(int checkoutNo){
	        this.nr_queue=checkoutNo;
	    }


		public BlockingQueue<Client> getQueue() {
	        return queue;
	    }

	    public void setQueue(BlockingQueue<Client> queue) {
	        this.queue = queue;
	    }

	    public ArrayList<Client> getQ() {
	        return q;
	    }

	    public void setQ(ArrayList<Client> q) {
	        this.q = q;
	    }

	    public int getCheckoutNo() {
	        return nr_queue;
	    }

	    public void setCheckoutNo(int checkoutNo) {
	        this.nr_queue = checkoutNo;
	    }


	    public int getNrclients() {
	        return nrclients;
	    }

	    public void setNrclients(int nrclients) {
	        this.nrclients = nrclients;
	    }

	    public int getRunTime() {
	        return runTime;
	    }

	    public void setRunTime(int runTime) {
	        this.runTime = runTime;
	    }

	    public int getMaxArrivalTime() {
	        return maxArrivalTime;
	    }

	    public void setMaxArrivalTime(int maxArrivalTime) {
	        this.maxArrivalTime = maxArrivalTime;
	    }

	    public int getMinArrivalTime() {
	        return minArrivalTime;
	    }

	    public void setMinArrivalTime(int minArrivalTime) {
	        this.minArrivalTime = minArrivalTime;
	    }

	    public int getMinProcessingWait() {
	        return minProcessingWait;
	    }

	    public void setMinProcessingWait(int minProcessingWait) {
	        this.minProcessingWait = minProcessingWait;
	    }

	    public int getMaxProcessingWait() {
	        return maxProcessingWait;
	    }

	    public void setMaxProcessingWait(int maxProcessingWait) {
	        this.maxProcessingWait = maxProcessingWait;
	    }

	    public void addc(Client c){
	        q.add(c);
	    }

	    public void removec(Client c){
	        q.remove(c);
	    }

	    public void addClient(Client c){
	        queue.add(c);
	    }

	    public void removeClient(Client c){
	        queue.remove(c);
	    }


	    @Override
	    public void run(){
	        while(true){
	            try{
	                Client c = queue.take();
	                Thread.sleep(c.getServicet()*100);

	            }

	            catch(Exception e){
	                e.printStackTrace();
	            }
	        }
	    }


	    public int getQueueSize(){
	        return queue.size();
	    }

	}
	

