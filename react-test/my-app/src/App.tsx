import React, { useEffect, useState } from 'react';

import './App.css';
import axios from 'axios';
const DOMAIN ="http://localhost:8080";
const MENU_API= "api/test/books"; 
interface GetListBookResponseDto{
  title : string; 
  author : string; 
  catrgory: string ;
}
function App() {
  const [category,setCategory] = useState<string>('');
  const [results,setResults] = useState<GetListBookResponseDto[]>([]);
  const handleCategory = (e: React.ChangeEvent<HTMLInputElement>) =>{
    setCategory(e.target.value); 
  }
  const fetchMenuData = async(category:string) =>{
    if(category.trim()) {
      try{
        
        const response = await axios.get(
          `${DOMAIN}/${MENU_API}/search/category`,
          { params: { category } }

        );

        const data = response.data.data; 
        setResults(data);
      }catch(error){
        console.error("Error fetching  data: ",error);
      }
    }
  }
  useEffect(() =>{
    fetchMenuData(category);
  },[category]);

  return (
    <div>책  전체 조회
       <input type='text' value={category} onChange={handleCategory}
      placeholder='Enter Category' required/>
      <ul>
        {results.map((result,index) => (
          <li key={index}>{result.title}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
