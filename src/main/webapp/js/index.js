fetch('userJSON.json')
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {
            appendData(data);
        })
        .catch(function (err) {
            console.log('error: ' + err);
        });
    function appendData(data) {
        var mainContainer = document.getElementById("allEmployees");
        var Employee_Data = data['Employee_Data']
        for (var i = 0; i < Employee_Data.length; i++) {
            var div = document.createElement("div");
            div.innerHTML = ' Employee ID: ' + Employee_Data[i].UserId + 'Name: ' + Employee_Data[i].FirstName + ' ' + Employee_Data[i].LastName + 'Username: ' + Employee_Data[i].UserName + ' Job Position: ' + Employee_Data[i].JobPosition;
            mainContainer.appendChild(div);
        }
    }
    
    fetch('userInfoJSON.json')
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {
            appendData(data);
        })
        .catch(function (err) {
            console.log('error: ' + err);
        });
    function appendData(data) {
        var mainContainer = document.getElementById("userInfo");
        var Employee_Data = data['Employee_Data']
        for (var i = 0; i < 1; i++) {
            var div = document.createElement("div");
            div.innerHTML = ' Employee ID: ' + Employee_Data[i].UserId + 'Name: ' + Employee_Data[i].FirstName + ' ' + Employee_Data[i].LastName + 'Username: ' + Employee_Data[i].UserName + ' Job Position: ' + Employee_Data[i].JobPosition;
            mainContainer.appendChild(div);
        }
    }