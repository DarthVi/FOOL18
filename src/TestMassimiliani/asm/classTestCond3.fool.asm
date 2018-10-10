push 0
push 0
push classA
new
push 0
push classB
new
push 0
push classC
new
push 1
push 1
beq label0
push 0
push classC
new
b label1
label0:
push 0
push classB
new
label1:
lfp
push -5
lfp
add
lw
copy
lw
push 0
add
lc
js
print
halt

function0:
cfp
lra
push 1
srv
sra
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

function3:
cfp
lra
push 10
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
push 4
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
push 100
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
function2
function4
classC:
function5
function1
function2
classnull:
