# МС Заявка

## API:
POST: /application - расчёт возможных условий кредита. Request - LoanApplicationRequestDTO, response - List<LoanOfferDTO>  
PUT: /application/offer - Выбор одного из предложений. Request LoanOfferDTO, response void.  

## Примеры запросов:

1. POST: http://localhost:8080/application
```
{
  "amount": 100000,
  "term": 12,
  "firstName": "Ivan",
  "lastName": "Ivanov",
  "middleName": "Ivanovich",
  "email": "ivanov@example.com",
  "birthdate": "1990-01-01",
  "passportSeries": "1234",
  "passportNumber": "567890"
}
```

Вывод:
```
[
    {
        "applicationId": 1,
        "requestedAmount": 100000,
        "totalAmount": 100000,
        "term": 12,
        "monthlyPayment": 9166.6667,
        "rate": 0.10,
        "insuranceEnabled": false,
        "salaryClient": false
    },
    {
        "applicationId": 1,
        "requestedAmount": 100000,
        "totalAmount": 100000,
        "term": 12,
        "monthlyPayment": 9083.3333,
        "rate": 0.09,
        "insuranceEnabled": false,
        "salaryClient": true
    },
    {
        "applicationId": 1,
        "requestedAmount": 100000,
        "totalAmount": 200000,
        "term": 12,
        "monthlyPayment": 17833.3333,
        "rate": 0.07,
        "insuranceEnabled": true,
        "salaryClient": false
    },
    {
        "applicationId": 1,
        "requestedAmount": 100000,
        "totalAmount": 200000,
        "term": 12,
        "monthlyPayment": 17666.6667,
        "rate": 0.06,
        "insuranceEnabled": true,
        "salaryClient": true
    }
]
```

2. PUT: http://localhost:8080/application/offer
```
{
        "applicationId": 1,
        "requestedAmount": 100000,
        "totalAmount": 100000,
        "term": 12,
        "monthlyPayment": 9166.6667,
        "rate": 0.10,
        "insuranceEnabled": false,
        "salaryClient": false
}
```
