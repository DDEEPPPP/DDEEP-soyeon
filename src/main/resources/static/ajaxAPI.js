
function tourData() {
    const API_KEY = "70axhgpopy3z4k5f";
    let API_URL = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=" + API_KEY + "&locale=kr&category=c1"
    fetch(API_URL).then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status : ${response.status}`);
        }
        return response.json();
    })
        .then(data => {
            console.log('Data:',data);
        })
        .catch(error => {
            console.error('Error:',error);
        });
}