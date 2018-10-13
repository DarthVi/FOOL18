push 0
push 0
push classpaperino
new
push 5
push 1
push classpluto
new
lfp
push -3
lfp
add
lw
push -2
lfp
add
lw
copy
lw
push 0
add
lc
js
halt

function0:
cfp
lra
lfp
push 1
lfp
add
lw
copy
lw
push 0
add
lc
js
push 0
beq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
lfp
push 1
lfp
add
lw
copy
lw
push 1
add
lc
js
b label1
label0:
push 1
label1:
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
push 1
push 0
lfp
add
lw
calchoff
add
lw
push 1
sub
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
push 1
push 0
lfp
add
lw
calchoff
add
lw
push 10
add
srv
sra
pop
sfp
lrv
lra
js
classpluto:
function1
function2
classpaperino:
function0
classnull:
