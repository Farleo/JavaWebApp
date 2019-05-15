var waitingMsg = false;
function getMessage(){
    console.log("getMessage")
    if(!waitingMsg){
        waitingMsg = true;
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function(){
            if(xhr.readyState == 4){
                if(xhr.status == 200){
                    var elem = document.getElementById('message');
                    elem.innerHTML = xhr.responseText + elem.innerHTML;
                }
                waitingMsg = false;
            }
        };
        console.log('/room?t='+new Date());
        xhr.open('get', '/room?t='+new Date(), true);
        xhr.send();
    }
}

setInterval(getMessage, 1000);

function postMessage(){
    console.log("postMessage")
    var xhr = new XMLHttpRequest();
    xhr.open('post','/room', false);
    xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
    var msg = escape(document.getElementById('msg').value);
    document.getElementById('msg').value='';
    xhr.send('msg='+msg+'&t='+new Date());
    console.log('msg='+msg+'&t='+new Date());
}