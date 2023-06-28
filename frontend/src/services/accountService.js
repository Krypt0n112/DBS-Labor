import axios from "axios"

const adress = process.env.BACKEND_ADRESS?process.env.BACKEND_ADRESS:"localhost";
const port = process.env.BACKEND_PORT?process.env.BACKEND_PORT:"8080";
const path = "http://" + adress + ":" + port + "/account"

const testPath = "http://localhost:8080/"

export const accountDataService = {
    createAccount(data){
        return axios.post(path + '/add', data);
    },
    getAccounts(){
        return axios.get(path + '/all');
    }
}