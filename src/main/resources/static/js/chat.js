var stompClient = null;


function connect() {
    // if (!$("#name").val()) {
    //     return;
    // }
    // 这里可以写/zty/chat或者chat（需要/会去除项目的前缀，而chat接口需要项目前缀）
    var socket = new SockJS('/zty/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {

        //
        stompClient.subscribe('/zty/user/queue/chat', function (chat) {
            showGreeting(JSON.parse(chat.body));
        });
    });
}

function sendMessage() {
    stompClient.send("/zty/app/chat", {}, JSON.stringify(
            {
                'content': $("#content").val(),
                'to': $("#to").val()
            }
        )
    );
}

function showGreeting(message) {
    $("#chatsContent").append("<div>" + message.from + ":" + message.content + "</div>");
}

$(function () {
    connect();

    $("#send").click(function () {
        sendMessage();
    });
})
