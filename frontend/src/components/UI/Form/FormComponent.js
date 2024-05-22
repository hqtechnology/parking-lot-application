import React, { useState } from 'react';
import { Form } from 'react-router-dom';

function FormComponent(props) {
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await fetch(serverUrl, {
      method: 'GET',
      headers: {
        Authorization: `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    });
  };

  return <Form onSubmit={handleSubmit}>{props.children}</Form>;
}

export default FormComponent;
