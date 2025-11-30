/* 打後端Web API */

// http://localhost:3000/tableHeader
// http://localhost:3000/tableBody

const baseURL = "http://localhost:3000";

async function fetchTableData(endpoint) {
  try {
    const response = await fetch(`${baseURL}/${endpoint}`);
    if (!response.ok) {
      console.log("response not ok");
      console.log("response ", response);
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    return await response.json();
  } catch (error) {
    console.log(`Fetch ${endpoint} failed `, error);
    return [];
  }
}

async function getTableHeader() {
  console.log("getTableHeader");
  return fetchTableData("tableHeader");
}

async function getTableBody() {
  console.log("getTableBody");
  return fetchTableData("tableBody");
}

export default {
  getTableHeader,
  getTableBody
};