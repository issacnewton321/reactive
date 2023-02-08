const axios = require("axios");

const sendTest = (json) => {
  axios
    .post("http://localhost:8080/user/", json)
    .then((res) => {
      console.log("response : " + JSON.stringify(res.data));
    })
    .catch((err) => console.log(err));
  // axios
  //   .get("http://localhost:8085/delay/")
  //   .then((res) => {
  //     console.log(res.data);
  //   })
  //   .catch((err) => {});
};

for (let i = 0; i < 1000; i++) {
  const json = {
    username: "hongquan" + i,
    address: "address" + i,
  };

  sendTest(json);
}
