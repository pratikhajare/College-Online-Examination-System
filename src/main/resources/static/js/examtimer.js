function makeTimer() {

	var d;
	if(sessionStorage.getItem("tdate")!=null)
	{
		d=new Date(sessionStorage.getItem("tdate"));
		console.log(sessionStorage.getItem("tdate") + "in get");
		console.log(d.toString()+" 2");
	}
	
var duration=document.getElementById('duration').value;
//var duration=0.05;
	var y=d.getFullYear();
	var m=d.getMonth();
	var date=d.getDate();
	
	var hrs=d.getHours();
	var eHrs=parseInt(hrs)+parseInt(duration);
	if(eHrs>=24)
	{
		eHrs=eHrs%24;
	}
	
	var mins=d.getMinutes()+((duration*60)%60);
	
	if(mins>60)
	{
		eHrs=eHrs+parseInt(mins/60);
		mins=mins%60;
	}
	
	var sec=d.getSeconds();
	
	console.log(duration+" "+" "+y+" "+m+" "+date+" "+hrs+" "+d.getMinutes()+" "+sec);
	console.log(eHrs+" "+mins+" ");
	
	var endTime;
	
   endTime = new Date(y,m,date,eHrs,mins,sec);
  // endTime=new Date(2021,09,08,22,00,00);
   var endTime = (Date.parse(endTime)) / 1000;
   var now = new Date();
   var now = (Date.parse(now) / 1000);
   var timeLeft = endTime - now;
   console.log(timeLeft+" timeleft");
   var days = Math.floor(timeLeft / 86400); 
   var hours = Math.floor((timeLeft - (days * 86400)) / 3600);
   var minutes = Math.floor((timeLeft - (days * 86400) - (hours * 3600 )) / 60);
   var seconds = Math.floor((timeLeft - (days * 86400) - (hours * 3600) - (minutes * 60)));
   if (hours < "10") { hours = "0" + hours; }
   if (minutes < "10") { minutes = "0" + minutes; }
   if (seconds < "10") { seconds = "0" + seconds; }
   $("#days").html(days + "<span>Days</span>");
   $("#hours").html(hours + "<span>Hours</span>");
   $("#minutes").html(minutes + "<span>Minutes</span>");
   $("#seconds").html(seconds + "<span>Seconds</span>");
   
   if(timeLeft<=0)
   {
        document.getElementById("submitexam").click();
	}
}

console.log(sessionStorage.getItem("tdate") +" zz");
if(sessionStorage.getItem("tdate")==null)
{
	console.log("in set")
	var td=new Date();
	sessionStorage.setItem("tdate",td.toString());
	console.log(td +" 1");
	
}
setInterval(function() { 
	makeTimer();
}, 0);
