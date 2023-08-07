import { hostNameUrl } from "../config/api";
import axios from "axios";

export const findBooks = (map) => {
  return axios.post(`${hostNameUrl}/myBooks`, map);
};

export const findBookTrades = (map) => {
    return axios.post(`${hostNameUrl}/security/myBooks`, map);
  };