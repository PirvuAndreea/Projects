package Main;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;


public class MonitoredData {
	private Date startTime = new Date();
	private Date endTime = new Date();
	private String activityLabel = new String();
	private List<MonitoredData> monitoredData;
	
	MonitoredData(Date startTime, Date endTime, String activityLabel) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.activityLabel = activityLabel;
		
	}
	
	MonitoredData() throws IOException, ParseException{
		parse();
	}
	
	public int getDate() {
		return startTime.getDate();
	}
	
	public Date getStartTime(){
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public DateTime getDateTime(){
		DateTime end = new DateTime(endTime);
		Duration d = new Duration(startTime);
		return end.minus(d);
	}
	
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getActivityLabel() {
		return activityLabel;
	}

	public void setActivityLabel(String activityLabel) {
		this.activityLabel = activityLabel;
	}
	
	public List<MonitoredData> getListaMD() {
		return this.monitoredData;
	}
	
	
	public void parse() throws IOException, ParseException{
		monitoredData = new ArrayList<>();
		Stream<String> stream = Stream.empty();
		stream = Files.lines(Paths.get("Activities.txt"));
		List<String> monitoredString = stream
	            .map(s -> s.split("\\s{2,100}")).flatMap(Arrays::stream)
	            .collect(Collectors.toList());
		for(int i = 0; i < monitoredString.size()-2; i+=3){
			startTime = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss").parse(monitoredString.get(i));
			endTime = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss").parse(monitoredString.get(i+1));
			activityLabel = monitoredString.get(i+2);
			MonitoredData data = new MonitoredData(startTime, endTime, activityLabel);
			monitoredData.add(data);
		}
	}
	
	
	public void task1() throws IOException, ParseException {
		PrintWriter writer = new PrintWriter("task_1.txt", "UTF-8");
		MonitoredData m=new MonitoredData();
		m.getListaMD().stream().forEach(e->writer.println(e.getStartTime()+" "+e.getEndTime()+" "+e.getActivityLabel()));
		writer.close();
		
	}
	
	public void distinctDays(){
		long distinct = monitoredData.stream().map(s -> s.getDate())
				.distinct()
				.count();
		try{
		    PrintWriter writer = new PrintWriter("task_2.txt", "UTF-8");
				writer.println("the number of distinct days is: "+distinct);
		    writer.close();
		} catch (IOException e) {
		}
	}
	
	public void distinctAction(){
		Map<String, Long> actions = monitoredData.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.counting()));
		
		try{
		    PrintWriter writer = new PrintWriter("task_3.txt", "UTF-8");
		    for( HashMap.Entry<String, Long> entry : actions.entrySet() ){
				writer.println(entry.getKey() + " occurs " + entry.getValue() + " times." );
			}
		    writer.close();
		} catch (IOException e) {
		}
	}
	
	public void eachDay(){
		Map<Integer, Map<String, Long>> eachDay = monitoredData.stream()
				.collect(Collectors.groupingBy(MonitoredData::getDate, Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.counting())));
		
		try{
		    PrintWriter writer = new PrintWriter("task_4.txt", "UTF-8");
		    for( HashMap.Entry<Integer, Map<String, Long>> entry : eachDay.entrySet() ){
				writer.println("Day " + entry.getKey()+ " ");
				for(HashMap.Entry<String, Long> e: entry.getValue().entrySet())
					writer.println(e.getKey() + " " + e.getValue());
				writer.println('\n');
			}
		    writer.close();
		} catch (IOException e) {
		}
		
	}
	
	public void durationLarger(){
		DateTime end = new DateTime(endTime);
		DateTime start = new DateTime(startTime);
		Map<String, Duration> period = monitoredData.stream()
				 .collect(Collectors.toMap(var -> var.activityLabel,
					       var  -> new Duration(new DateTime(var.startTime), new DateTime(var.endTime)), Duration::plus));
		Map<String, Duration> period2 = period.entrySet().stream()
				.filter(map -> map.getValue().getStandardHours() > 0)
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		try{
		    PrintWriter writer = new PrintWriter("task_5.txt", "UTF-8");
		    for( HashMap.Entry<String, Duration> entry : period2.entrySet() ){
				writer.println(entry.getKey() + "	-- " + entry.getValue().getStandardMinutes()+ " minutes");	
			}
		    writer.close();
		} catch (IOException e) {
		}
	}
	
	public void lessThan5(){
		Map<String, Long> actions = monitoredData.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.counting()));
		Map<String, Long> actions2 = monitoredData.stream()
				.filter((var -> new Duration(new DateTime(var.startTime), new DateTime(var.endTime)).getStandardMinutes() < 5))
				.collect(Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.counting()));
		
		List<String> list = new ArrayList<String>();
		
		actions.forEach((key1,value1) -> { actions2.forEach((key2, value2) -> {
			if(key1.equals(key2))
				if(value2 >= value1*9/10)
					list.add(key1);
		});});
				
		try{
		 PrintWriter writer = new PrintWriter("task_6.txt", "UTF-8");
		 for(String s: list)
				writer.println(s);
		 writer.close();
		} catch (IOException e) {
		}
		
	}

	
	
	public static void main(String[] args) throws IOException, ParseException {
		MonitoredData m = new MonitoredData();
		m.task1();
		m.distinctDays();
		m.distinctAction();
		m.eachDay();
		m.durationLarger();
		m.lessThan5();
	}
	
}
