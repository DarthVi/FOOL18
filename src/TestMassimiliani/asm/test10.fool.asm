push 11
push 10
bleq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
push 10
push 8
bleq label6
push 0
b label7
label6:
push 1
label7:
push 1
beq label4
push 7
push 5
beq label10
push 0
b label11
label10:
push 1
label11:
push 1
beq label8
push 5
push 5
bleq label14
push 0
b label15
label14:
push 1
label15:
push 1
beq label12
push 5
push 5
beq label18
push 0
b label19
label18:
push 1
label19:
push 1
beq label16
push 7
b label17
label16:
push 5
push 5
bleq label22
push 0
b label23
label22:
push 1
label23:
push 1
beq label20
push 6
b label21
label20:
push 5
label21:
label17:
b label13
label12:
push 4
label13:
b label9
label8:
push 30
label9:
b label5
label4:
push 2
label5:
b label1
label0:
push 1
label1:
halt
