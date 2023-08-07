import { hostNameUrl } from "../config/api";
import axios from "axios";

export const findBonds = () => {
  return axios.get(`${hostNameUrl}/securities`);
};

export const userLogin = (credentials) => {
  return axios.post(`${hostNameUrl}/login` , credentials);
};

export const isinSearch = (isin) => {
  return axios.post(`${hostNameUrl}/securities/issinOrCusip`, isin);
};

export const maturitySearch = (maturity) => {
  return axios.post(`${hostNameUrl}/securities/within5days`, maturity);
}

export const bookSearch = (user) => {
  return axios.post(`${hostNameUrl}/securities/user`,user);
}