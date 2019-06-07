describe('测试Todo App的添加功能',function () {
    it('添加一项待办事项', function () {
        cy.visit('http://localhost:8080/')
        //测试添加功能
        cy.get('#app > div > form > input[type="text"]').type('buy some cheese')
        cy.get('#app > div > form > button').click()
        cy.get('#app > div > form > input[type="text"]').type('play basketball')
        cy.get('#app > div > form > button').click()
        //测试删除功能
        cy.get('#app > div > form > input[type="text"]').type('eat dinner')
        cy.get('#app > div > form > button').click()
        cy.get('#app > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > button.delete-btn').click()
        //测试编辑功能
        cy.get('#app > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > button:nth-child(1)').click()
        cy.get('#app > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > form > input').clear()
        cy.get('#app > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > form > input').type('study for 2 hours')
        cy.get('#app > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > button:nth-child(1)').click()
    })
})