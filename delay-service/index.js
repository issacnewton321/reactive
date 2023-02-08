const express = require("express");
const PORT = 8085;

const app = express();

app.get("/delay", (req, res) => {
  const DELAY_TIME = 2000;
  setTimeout(() => {
    res.json("delay after " + DELAY_TIME);
  }, DELAY_TIME);
});

app.listen(PORT, () => {
  console.log("service listen on port " + PORT);
});
