import React, { useCallback, useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import SprintAxios from '../../apis/SprintAxios';
import { jwtDecode } from 'jwt-decode';
import {Col, Container, Form, Row, Button, Table, ButtonGroup} from 'react-bootstrap';

const Zadaci = () => {

 
  const[searchParams, setSearchParams] = useState({
    ime: '',
    sprintId: null    
  });


  const[zadaci, setZadaci] = useState([]);
  const[pageNo, setPageNo] = useState([]);
  const[maxPages, setMaxPages] = useState([]);
  const[sprintovi, setSprintovi] = useState([]);
  const[isChecked, setIsChecked] = useState(false);



  const navigate = useNavigate()


  const token = localStorage.getItem("jwt");
  const decoded = token ? jwtDecode(token) : null;
  const isAdmin = decoded?.role?.authority === "ROLE_ADMIN";

  const getZadaci = () => {

    console.log(searchParams);
    
    SprintAxios.get(`/zadaci?pageNo=${pageNo}`, {
      params: {
        ime: searchParams.ime,
        sprintId: searchParams.sprintId

    }})
    .then(res => {
      console.log(res.data);
      setMaxPages(res.headers["total-pages"])
      setZadaci(res.data); 
    })
    .catch(error => {
      console.log("Error!");
    });

  };


  const getSprintovi = () => {
    SprintAxios.get("/sprintovi")
    .then(res => {
      console.log(res.data);
      setSprintovi(res.data);
    })
    .catch(error => {
      console.log(error);
    })
  }

  useEffect(() => {
    getSprintovi()
  }, [])

  useEffect(() => {
    getZadaci()
  }, [pageNo])



  const deleteZadatak = (zadatakId) => {
    SprintAxios.delete("/zadaci/" + zadatakId)
    .then(res=> {
      console.log(res);
      alert("Uspesno brisanje!");
      window.location.reload();
    })
    .catch(error => {
      alert("Error!")
    })

  }

  const goToEdit = (zadatakId) => {
    navigate("/zadaci/" + zadatakId);
  }

  const handleChange = (e) => {
  let unetiParams = {...searchParams};

   const name = e.target.name;
   const value = e.target.value;

   unetiParams[name] = value;
   setSearchParams(unetiParams);
  }

  const handleSearch = () => {
    getZadaci();
  }

  const handlePrelazak = (zadatak) => {
    console.log(zadatak);

    SprintAxios.put("/zadaci/" + zadatak.id + "/next", zadatak)
    .then((res)=> {
       console.log(res.data);
      getZadaci();
    })
    .catch((error)=>{
      console.log(error);
    })
  }






  const renderZadaci = () => {
    return zadaci.map((zadatak, index) => {

  

      return(
        <tr key={zadatak.id}>
          <td>{ zadatak.ime }</td>
          <td>{ zadatak.zaduzeni }</td>
          <td>{ zadatak.bodovi }</td>
          <td>{ zadatak.stanjeIme }</td>
          <td>{ zadatak.sprintIme }</td>
          { isAdmin?
          <td>
          <Button variant="info" disabled={zadatak.stanjeIme === "ZAVRŠENO"} style={{margin: "2px"}} onClick={() => {handlePrelazak(zadatak)}}>Pređi na sledeće stanje</Button>
          <Button variant="warning" style={{marginLeft: 5}} onClick={() => {goToEdit(zadatak.id)}}>Izmeni</Button>
          <Button variant="danger" style={{marginLeft: 5}} onClick={() => deleteZadatak(zadatak.id)}>Obriši</Button>
          </td>
          :
          null

          }
          

        </tr>
      )


    })
  }


  const goToAdd = () => {
    navigate("/zadaci/add")
  }

  const handleCheck = () => {
    setIsChecked(!isChecked);    
  }


  return(
    <Container style={{paddingTop:"10px", paddingLeft:"10px", paddingRight:"5px"}}>
     
      
      <Row style={{marginBottom:"20px"}} className="justify-content-center">
      <Form style={{width: "50%"}}>
        <Form.Check type="switch"
        id="custom-switch"
        label="Prikaži formu za pretragu"
        defaultChecked=""
        style={{marginTop:"20px"}}
        onChange={handleCheck}
      />
         
          { isChecked?
           <div>
          <Form.Group style={{marginTop:"10px"}}>
            <Form.Label htmlFor="">Ime zadatka</Form.Label>
            <Form.Control style={{ width: "25%"}}  type="text" name="ime" onChange={handleChange} />
          </Form.Group>
          <Form.Group style={{marginTop:"10px"}}>
            <Form.Label htmlFor="">Sprint</Form.Label>
            <Form.Control type="select" as="select" name="sprintId" style={{ width: "25%"}}  onChange={handleChange} > 
        <option value={""}>Izaberite sprint</option>
        {
          sprintovi.map((el, i) => {
            return <option key={el.i} value={el.id}>{el.ime}</option>
          })
        }
        </Form.Control>
          </Form.Group>
         
          <Button className="button button-navy" style={{marginTop: "10px", marginBottom: "10px"}} onClick={handleSearch}>Pretraga</Button>
       
          </div>
          :
          null
      }
       
        
        
        </Form>
      

      </Row>



      <div style={{ display: 'flex', justifyContent: "space-between", width: '100%' }}>
 
      { isAdmin? 
        <Button  className="button button-navy" style={{marginBottom: "10px"}} onClick={goToAdd}>Kreiraj zadatak</Button>
        :
        null
      }
      <ButtonGroup style={{ marginTop: 25, float:"right"}}>
      <Button style={{ margin: 3, width: 90}} disabled={pageNo <= 0} className="button button-navy"  onClick={() => setPageNo(pageNo -1)}>Prethodna</Button>
      <Button style={{ margin: 3, width: 90}} disabled={pageNo >= maxPages -1} className="button button-navy" onClick={() => setPageNo(pageNo +1)}>Sledeća</Button>
      </ButtonGroup>
     
      </div>
      <Table bordered striped style={{ marginTop: 5 }}>
   
      <thead className="thead-dark">
          <tr>
            <th>Ime</th>
            <th>Zaduženi</th>
            <th>Bodovi</th>
            <th>Stanje</th>
            <th>Sprint</th>
            {
              isAdmin?

              <th>Akcija</th>
              :
              null
            }
            

          </tr>
      </thead>
        <tbody>
          {renderZadaci()}
   
        </tbody>

      </Table>
      
    </Container>
  )

}

export default Zadaci