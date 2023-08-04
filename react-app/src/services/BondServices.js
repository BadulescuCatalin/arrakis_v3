import { hostNameUrl } from "../config/api";
import axios from "axios";

export const findBonds = () => {
  return axios.get(`${hostNameUrl}/bonds`);
};

export const userLogin = (credentials) => {
  return axios.post(`${hostNameUrl}/login` , credentials);
};

export const isinSearch = (isin) => {
  return axios.post(`${hostNameUrl}/isin`, isin);
};

export const maturitySearch = (maturity) => {
  return axios.post(`${hostNameUrl}/maturity`, maturity);
}