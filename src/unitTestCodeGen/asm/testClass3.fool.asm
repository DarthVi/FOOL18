push 0
push 0
push 1
beq label0
push 0
b label1
label0:
push 0
push 1
beq label2
push 0
b label1
label2:
push 1
label1:
push -2
lfp
add
lw
push 1
beq label3
push 30
push 1
push classC
new
b label4
label3:
push 10
push 1
push classB
new
label4:
lfp
push 3
push -3
lfp
add
lw
copy
lw
push 0
add
lc
js
lfp
push -3
lfp
add
lw
copy
lw
push 2
add
lc
js
add
halt

function0:
cfp
lra
push 1
lfp
add
lw
srv
sra
pop
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 2
srv
sra
pop
sfp
lrv
lra
js

function2:
cfp
lra
push 3
srv
sra
pop
sfp
lrv
lra
js

function4:
cfp
lra
push 3
srv
sra
pop
sfp
lrv
lra
js

function5:
cfp
lra
push 4
srv
sra
pop
sfp
lrv
lra
js

function3:
cfp
lra
push 1
lfp
add
lw
push 1
lfp
add
lw
mult
srv
sra
pop
pop
sfp
lrv
lra
js

function6:
cfp
lra
push 1
lfp
add
lw
push 1
lfp
add
lw
push 1
lfp
add
lw
mult
mult
srv
sra
pop
pop
sfp
lrv
lra
js

function7:
cfp
lra
push 20
srv
sra
pop
sfp
lrv
lra
js
classA:
function0
function1
function2
classB:
function3
function1
function4
function5
classC:
function6
function7
function2
classnull:
