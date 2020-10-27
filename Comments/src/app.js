const express =require("express")
const app =  express()
require("./db/db")
const port =3000

app.listen(port,()=>{
    console.log(`listenning to ${port}`)
})