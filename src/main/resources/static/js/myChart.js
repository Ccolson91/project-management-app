var chartData = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartData);

var arrayLength = chartJsonArray.length;
var numericData = [];
var labelData = [];

for(let i=0; i < arrayLength; i++) {
    numericData[i] = chartJsonArray[i].value;
    labelData[i] = chartJsonArray[i].label;
}

// For a pie chart
//var myPieChart = new Chart(ctx, {
//    type: 'pie',
//    data: data,
//    options: options
//});

// Changing generic pie chart code for our needs
//new Chart(document.getElementById("myPieChart"), {
       // The data for our dataset
//    const labels = [
//        'January',
//        'February',
//        'March',
//        'April',
//        'May',
//        'June',
//      ];

      const data = {
        labels: labelData,
        datasets: [{
          label: 'My First dataset',
          backgroundColor: ["#3e95cd", "8e5ea2", "#3cba9f"],
          data: numericData,
        }]
      };

      const config = {
        type: 'pie',
        data: data,
        options: {
            title: {
                display: true,
                text: 'Project Statuses'
            }
        }
    };

    new Chart(document.getElementById('myPieChart'), config);

// following code turns our cryptic jsonString data and decodes it into readable JSON to work with
    // [{"value": 1, "label": "COMPLETED"},{"value": 2, "label": "INPROGRESS"},{"value": 1, "label": "NOTSTARTED"}]
    function decodeHtml(html){
        var txt = document.createElement("textarea");
        txt.innerHTML = html;
        return txt.value;
    }