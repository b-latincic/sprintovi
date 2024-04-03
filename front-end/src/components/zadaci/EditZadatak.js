import React, { useEffect, useState } from 'react';
import {Col, Container, Row, Form, Button} from 'react-bootstrap';
import {useNavigate, useParams} from 'react-router-dom';
import SprintAxios from '../../apis/SprintAxios';



const EditZadatak = () => {

  let emptyZadatak = {  
    ime: '',
    zaduzeni: '',
    bodovi: -1,
    stanjeId: -1,
    sprintId: -1
  }

  const navigate = useNavigate()

  const[sprintovi, setSprintovi] = useState([])
  const[stanja, setStanja] = useState([])
  const[zadatak, setZadatak] = useState(emptyZadatak);



  const routeParams = useParams ();
  const zadatakId = routeParams.id;




  const getZadatakById = () => {
    SprintAxios.get("/zadaci/" + zadatakId)
    .then(res=>{
      console.log(res.data);
      setZadatak(res.data);
    })
    .catch(error=> {
      console.log(error);
      alert("Error!")
    });
  }


  const getSprintovi = () => {
    SprintAxios.get("/sprintovi")
    .then(res => {
      console.log(res.data);
      setSprintovi(res.data)
    })
    .catch(error => {
      console.log(error);
    })
  }


  const getStanja = () => {
    SprintAxios.get("/stanja")
    .then(res => {
      console.log(res.data);
      setStanja(res.data);
    })
    .catch(error => {
      console.log(error);
    })
  }

  const handleChange = (e) => {
    let zadatakIzmena = {...zadatak}

    const name = e.target.name;
    const value = e.target.value;

    zadatakIzmena[name] = value;
    setZadatak(zadatakIzmena)
  }




  const edit = () => {
   
   
    SprintAxios.put("/zadaci/" + zadatakId, zadatak)
    .then(()=> {
       alert("Uspesna izmena!")
       navigate("/zadaci")      
    })
    .catch((error)=>{
      console.log(error);
    })
    
  }



  useEffect(() => {
    getZadatakById()
    getSprintovi()
    getStanja()
  }, []);




  return(
    <Container style={{paddingTop:"10px", paddingLeft:"10px"}}>
    <Col>
     
    <Row style={{marginBottom:"20px"}} className="justify-content-center">
  
  <Form style={{width: "50%"}}>
        <Form.Group>
        <Form.Label htmlFor="">Ime</Form.Label>
        <Form.Control style={{ width: "25%"}}  type="text" name="ime" onChange={handleChange} />
        </Form.Group>
        <Form.Group>
        <Form.Label  style={{marginTop:"10px"}} htmlFor="">Zaduženi</Form.Label>
        <Form.Control style={{ width: "25%"}}  type="text" name="zaduzeni" onChange={handleChange}  />
        </Form.Group>
        <Form.Group>
        <Form.Label style={{marginTop:"10px"}} htmlFor="">Bodovi</Form.Label>
        <Form.Control style={{ width: "25%"}}  type="number" name="bodovi" onChange={handleChange} />
        </Form.Group>
        <Form.Group>
        <Form.Label style={{marginTop:"10px"}} htmlFor="">Stanje</Form.Label>
        <Form.Control style={{ width: "25%"}} type="select" as="select" name="stanjeId" onChange={handleChange} >
        <option value={null}>Izaberite stanje</option>
        {
          stanja.map((el, i) => {
            return <option key={el.i} value={el.id}>{el.ime}</option>
          })
        }
        </Form.Control>
        </Form.Group>
        <Form.Group>
        <Form.Label style={{marginTop:"10px"}} htmlFor="">Sprint</Form.Label>
        <Form.Control type="select" as="select" name="sprintId" style={{ width: "25%"}}  onChange={handleChange} > 
        <option value={null}>Izaberite sprint</option>
        {
          sprintovi.map((el, i) => {
            return <option key={el.i} value={el.id}>{el.ime}</option>
          })
        }
        </Form.Control>

        </Form.Group>
        <Button style={{marginTop:"10px"}} className="button button-navy" onClick={() => edit()}>Izmeni</Button>
    </Form>
    </Row>
   
    </Col>
  </Container>
  );

}

export default EditZadatak;